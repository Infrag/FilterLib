/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.processors.valuerestrictions;

import org.obozek.filterlib.processors.Interval;

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
