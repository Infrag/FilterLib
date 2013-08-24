package org.filterlib.dao;

/**
 * ProcessorException is thrown when ome problems with processors arise (i.e.
 * InstantiationException)
 *
 * @author Ondrej.Bozek
 */
public class ProcessorException extends RuntimeException
{

    public static final String DEFAULT_MESSAGE = "Error instantiating processor class - %s";

    public ProcessorException(String message)
    {
        super(message);
    }

    public ProcessorException(Class processorClass, Exception e)
    {
        super(String.format(DEFAULT_MESSAGE, processorClass), e);
    }

    public ProcessorException(String message, Exception e)
    {
        super(message, e);
    }
}
