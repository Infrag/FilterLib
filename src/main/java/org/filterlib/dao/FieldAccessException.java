package org.filterlib.dao;

import java.lang.reflect.Field;

/**
 * FieldAccessException is thrown when some problems with accesing filter fields
 * arise
 *
 * @author Ondrej.Bozek
 */
public class FieldAccessException extends RuntimeException
{

    public static final String DEFAULT_MESSAGE = "Error accesing field %s, from class %s on class %s";

    public FieldAccessException(Field field, Object valueClass, Throwable throwable)
    {
        super(String.format(DEFAULT_MESSAGE, field.getName(),
                field.getDeclaringClass(), valueClass.getClass()), throwable);
    }

    public FieldAccessException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
