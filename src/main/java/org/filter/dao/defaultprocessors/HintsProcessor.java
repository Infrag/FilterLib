/*
 * Project: FilterLib
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Apr 26, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.filter.dao.defaultprocessors;

import org.filter.dao.Hint;
import org.filter.dao.ProcessorContext;
import java.util.List;

/**
 *
 * @author Ondrej.Bozek
 */
public class HintsProcessor implements ClassProcessor<List<Hint>>
{
    
    public void processCustomField(List<Hint> value, ProcessorContext<Object> processorContext)
    {
        if (value != null && !value.isEmpty()) {
            processorContext.getHints().addAll(value);
        }
    }
}
