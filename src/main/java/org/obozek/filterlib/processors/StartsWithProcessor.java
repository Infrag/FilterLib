package org.obozek.filterlib.processors;

import org.obozek.filterlib.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang.StringUtils;
import org.obozek.filterlib.processors.valuerestrictions.BlankStringValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.ValueRestriction;

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
