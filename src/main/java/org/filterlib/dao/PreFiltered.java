/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Ondrej.Bozek
 */
public interface PreFiltered
{

    /**
     * Get pre filters for class
     *
     * @return
     */
    Map<Class<?>, List<Object>> getPreFilters();

    /**
     * Get preFilters for class
     *
     * @param clazz
     * @return
     */
    List<Object> getPreFilters(Class<?> clazz);
}
