/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valueholders;

/**
 * Basice default value which is ignored by standard processors. Extensions of
 * this class can be used for implementation of other default values
 *
 * Ignored Value = null
 *
 * @author infragile
 */
public interface BasicValueHolder {

    public static final String VALUE_FIELD_NAME = "VALUE";
    public static final Object VALUE = null;
}
