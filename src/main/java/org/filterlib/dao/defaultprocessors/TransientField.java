package org.filterlib.dao.defaultprocessors;

import org.filterlib.dao.CustomProcessor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Fields marked by this annotation are just ignored and not processed
 *
 * @author Ondrej.Bozek
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CustomProcessor(TransientProcessor.class)
public @interface TransientField
{
}
