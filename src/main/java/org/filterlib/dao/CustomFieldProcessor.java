package org.filterlib.dao;

/**
 * T - represents Entity type, 
 * V - represents value from filter
 *
 * @author Ondrej.Bozek
 */
public interface CustomFieldProcessor<T extends Object, V>
{

    public void processCustomField(V value, ProcessorContext<T> processorContext);
}
