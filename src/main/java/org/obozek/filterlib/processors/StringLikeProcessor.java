package org.obozek.filterlib.processors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import org.obozek.filterlib.ProcessorContext;
import org.obozek.filterlib.processors.valuerestrictions.BlankStringValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.ValueRestriction;

/**
 *
 * @author Ondrej.Bozek
 */
public class StringLikeProcessor extends AbstractClassProcessor<String> {

    private static final Class[] DEFAULT_IGNORED_VALUES_RESTRICTIONS = {BlankStringValueRestriction.class};

    @Override
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        return DEFAULT_IGNORED_VALUES_RESTRICTIONS;
    }

    @Override
    protected void processRelevantField(String value, ProcessorContext<Object> processorContext) {
        CriteriaBuilder cb = processorContext.getEntityManager().getCriteriaBuilder();
        Predicate p;
        p = cb.like(cb.lower(processorContext.<String>getPath()), "%" + (value).toLowerCase() + "%");
        processorContext.addPredicate(p);

    }
}
