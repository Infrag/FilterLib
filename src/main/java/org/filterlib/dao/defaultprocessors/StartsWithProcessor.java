package org.filterlib.dao.defaultprocessors;

import org.filterlib.dao.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Ondrej.Bozek
 */
public class StartsWithProcessor implements ClassProcessor<String> {

    @Override
    public void processCustomField(String value, ProcessorContext<Object> processorContext) {
        if (StringUtils.isNotBlank(value)) {
            CriteriaBuilder cb = processorContext.getCriteriaBuilder();
            processorContext.addPredicate(
                    cb.like(processorContext.<String>getPath(), value + "%"));
        }
    }
}
