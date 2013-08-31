package org.filterlib.dao.defaultprocessors;

import org.filterlib.dao.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang.StringUtils;
import org.filterlib.dao.defaultprocessors.valuerestrictions.BlankStringValueRestriction;
import org.filterlib.dao.defaultprocessors.valuerestrictions.ValueRestriction;

/**
 *
 * @author Ondrej.Bozek
 */
public class StartsWithProcessor extends AbstractClassProcessor<String> {

    private static final Class[] DEFAULT_IGNORED_VALUES_RESTRICTIONS = {BlankStringValueRestriction.class};

    @Override
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        return DEFAULT_IGNORED_VALUES_RESTRICTIONS;
    }

    @Override
    protected void processRelevantField(String value, ProcessorContext<Object> processorContext) {
        CriteriaBuilder cb = processorContext.getCriteriaBuilder();
        processorContext.addPredicate(
                cb.like(processorContext.<String>getPath(), value + "%"));
    }
}
