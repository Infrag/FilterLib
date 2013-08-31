/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valuerestrictions;

import java.util.Collection;

/**
 *
 * @author infragile
 */
public class EmptyCollectionValueRestriction implements ValueRestriction<Collection> {

    @Override
    public Boolean isValueIgnored(Collection value) {
        return value == null || value.isEmpty();
    }
}
