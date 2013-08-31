/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valuerestrictions;

/**
 *
 * @author infragile
 */
public class BasicValueRestriction implements ValueRestriction {

    @Override
    public Boolean isValueIgnored(Object value) {
        return value == null;
    }
}
