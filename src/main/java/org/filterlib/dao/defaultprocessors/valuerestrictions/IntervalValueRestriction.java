/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valuerestrictions;

import org.filterlib.dao.defaultprocessors.Interval;

/**
 *
 * @author infragile
 */
public class IntervalValueRestriction implements ValueRestriction<Interval> {

    @Override
    public Boolean isValueIgnored(Interval value) {
        return value == null || (!value.maxIsNotNull() && !value.minIsNotNull());
    }
}
