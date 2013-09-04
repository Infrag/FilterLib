package org.obozek.filterlib.processors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import org.apache.commons.lang.StringUtils;
import org.obozek.filterlib.ProcessorContext;
import org.obozek.filterlib.processors.valuerestrictions.BlankStringValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.ValueRestriction;

/**
 * Processor takes care about naive full text search
 *
 *
 * @author Ondrej.Bozek
 */
public class NaiveFullTextProcessor extends AbstractClassProcessor<String> {

    private static final Class[] DEFAULT_IGNORED_VALUES_RESTRICTIONS = {BlankStringValueRestriction.class};

    @Override
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        return DEFAULT_IGNORED_VALUES_RESTRICTIONS;
    }

    @Override
    protected void processRelevantField(String value, ProcessorContext<Object> processorContext) {
        Expression<String> expression = processorContext.getPath();
        CriteriaBuilder cb = processorContext.getCriteriaBuilder();

        // deal with CASE SENSITIVITY
        NaiveFullText naiveFullTextAnnotation = processorContext.getField().getAnnotation(NaiveFullText.class);
        if (!naiveFullTextAnnotation.caseSensitive()) {
            value = value.toLowerCase();
            expression = cb.lower(expression);
        }

        String[] tokens = StringUtils.split(value);
        for (String string : tokens) {
            processorContext.addPredicate(
                    cb.like(expression, "%" + string + "%"));
        }
    }
}
