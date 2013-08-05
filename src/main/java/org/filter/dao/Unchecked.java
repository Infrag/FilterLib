package org.filter.dao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation disables throwing of exception when no appropriate handling
 * is found for field. - Use with care!
 *
 * Can be applied on field or on whole filtering object
 *
 * @author Ondrej.Bozek
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Unchecked
{
}
