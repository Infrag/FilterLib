package org.filterlib.dao.defaultprocessors;

import org.filterlib.dao.ProcessorContext;

/**
 * This processor just ignores field completely
 *
 * @author Ondrej.Bozek
 */
public class TransientProcessor implements ClassProcessor<Object>
{

    public void processCustomField(Object value, ProcessorContext<Object> processorContext)
    {
    }
}
