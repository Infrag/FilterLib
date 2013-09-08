/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * Pre filter accessor can be used as implementation for retrieving of
 * preFilters and later injected in to DAO object
 *
 * <p>Pre filters are used for pre-filtering of results. These filters are
 * always utilized for all searches for matching entities.</p> Can be used for:
 * <ul> <li>row level security, </li> <li>multitenancy, </li>
 * <li>shared tables, </li> <li>soft deletes, </li> <li>data history,</li>
 * <li>temporal filtering </li> <li>etc...</li> </ul>
 *
 * @author Ondrej.Bozek
 */
public interface PreFilterAccessor
{

    /**
     *
     * @param filter
     * @return
     */
    List<Object> getPreFilters(Class<?> entityClass, Pageable filter);
}
