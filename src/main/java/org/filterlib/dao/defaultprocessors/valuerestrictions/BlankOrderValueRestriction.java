/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valuerestrictions;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort.Order;

/**
 *
 * @author infragile
 */
public class BlankOrderValueRestriction implements ValueRestriction<Order> {

    @Override
    public Boolean isValueIgnored(Order value) {
        return value == null || StringUtils.isBlank(value.getProperty());
    }
}
