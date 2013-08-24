package org.filterlib.dao.defaultprocessors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import org.apache.commons.lang.StringUtils;
import org.filterlib.dao.ProcessorContext;

/**
 * Processor takes care about naive full text search
 *
 *
 * @author Ondrej.Bozek
 */
public class NaiveFullTextProcessor implements ClassProcessor<String> {

    @Override
    public void processCustomField(String value, ProcessorContext<Object> processorContext) {
        if (StringUtils.isNotBlank(value)) {
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
}
