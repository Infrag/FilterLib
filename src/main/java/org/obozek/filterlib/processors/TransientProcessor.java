package org.obozek.filterlib.processors;

import org.obozek.filterlib.ProcessorContext;

/**
 * This processor just ignores field completely
 *
 * @author Ondrej.Bozek
 */
public class TransientProcessor implements ClassProcessor<Object>
{

    @Override
    public void processCustomField(Object value, ProcessorContext<Object> processorContext)
    {
    }
}
