package org.filter.dao.defaultprocessors;

import org.filter.dao.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Ondrej.Bozek
 */
public class StartsWithProcessor implements ClassProcessor<String>
{

    @Override
    public void processCustomField(String value, ProcessorContext<Object> processorContext)
    {
        if (StringUtils.isNotBlank(value)) {
            CriteriaBuilder cb = processorContext.getCriteriaBuilder();
            processorContext.addPredicate(
                    cb.like(processorContext.getPath(), value + "%"));
        }
    }
}
