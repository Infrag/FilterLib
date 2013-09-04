/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.processors.valuerestrictions;

/**
 *
 * @author infragile
 */
public interface ValueRestriction<T> {

    public Boolean isValueIgnored(T value);
}
