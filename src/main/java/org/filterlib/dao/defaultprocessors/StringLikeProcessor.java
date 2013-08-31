package org.filterlib.dao.defaultprocessors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import org.filterlib.dao.ProcessorContext;
import org.filterlib.dao.defaultprocessors.valuerestrictions.BlankStringValueRestriction;
import org.filterlib.dao.defaultprocessors.valuerestrictions.ValueRestriction;

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
