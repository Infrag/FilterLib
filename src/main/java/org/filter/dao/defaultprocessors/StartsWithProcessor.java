/*
 * Project: FilterLib
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Jul 18, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
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

    public void processCustomField(String value, ProcessorContext<Object> processorContext)
    {
        if (StringUtils.isNotBlank(value)) {
            CriteriaBuilder cb = processorContext.getCriteriaBuilder();
            processorContext.addPredicate(
                    cb.like(processorContext.getPath(), value + "%"));
        }
    }
}
