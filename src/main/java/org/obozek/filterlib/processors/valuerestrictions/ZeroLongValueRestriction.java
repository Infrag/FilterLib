/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.processors.valuerestrictions;

/**
 *
 * @author infragile
 */
public class ZeroLongValueRestriction implements ValueRestriction<Long> {

    private static final Long IGNORED_VALUE = 0L;

    @Override
    public Boolean isValueIgnored(Long value) {
        return value != null && IGNORED_VALUE.equals(value);
    }
}
