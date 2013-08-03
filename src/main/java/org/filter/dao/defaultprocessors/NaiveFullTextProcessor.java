package org.filter.dao.defaultprocessors;

import org.filter.dao.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang.StringUtils;

/**
 * 
 *
 * @author Ondrej.Bozek
 */
public class NaiveFullTextProcessor implements ClassProcessor<String>
{

    public void processCustomField(String value, ProcessorContext<Object> processorContext)
    {
        if (StringUtils.isNotBlank(value)) {
            CriteriaBuilder cb = processorContext.getCriteriaBuilder();
            String[] tokens = StringUtils.split(value);
            for (String string : tokens) {
                processorContext.addPredicate(
                        cb.like(processorContext.getPath(), "%" + string + "%"));
            }
        }
    }
}
