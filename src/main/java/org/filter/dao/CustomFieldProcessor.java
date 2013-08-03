package org.filter.dao;

/**
 *
 * @author Ondrej.Bozek
 */
public interface CustomFieldProcessor<T extends Object, V>
{

    public void processCustomField(V value, ProcessorContext<T> processorContext);
}
