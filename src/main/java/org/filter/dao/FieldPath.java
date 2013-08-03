/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filter.dao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for specification of Target field path in different way tha
 * using field name. Beware here is used dot notation for path traverse e.g.
 * "field.subfield"
 *
 * @author Ondrej.Bozek
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldPath
{

    public static final String FIELD_PATH_SEPARATOR = ".";

    /**
     * Specify target field path. Beware here is used dot notation for path
     * traverse e.g. "field.subfield"
     *
     * @return
     */
    String value();
}
