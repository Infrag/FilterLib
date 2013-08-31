/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valuerestrictions;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author infragile
 */
public class BlankStringValueRestriction implements ValueRestriction<String> {

    @Override
    public Boolean isValueIgnored(String value) {
        return StringUtils.isBlank(value);
    }
}
