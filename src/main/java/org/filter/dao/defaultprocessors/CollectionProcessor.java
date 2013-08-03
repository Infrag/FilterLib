/*
 * Project: FilterLib
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Apr 17, 2013
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
import java.util.Collection;
import javax.persistence.criteria.Predicate;

/**
 * Basic list processor for processing of list of values
 *
 * @author Ondrej.Bozek
 */
public class CollectionProcessor<T extends Comparable> implements ClassProcessor<Collection<T>>
{

    public void processCustomField(Collection<T> value, ProcessorContext<Object> processorContext)
    {
        if (value != null && !value.isEmpty()) {
            Predicate p = processorContext.getPath().in(value);
            processorContext.addPredicate(p);
        }
    }
}
