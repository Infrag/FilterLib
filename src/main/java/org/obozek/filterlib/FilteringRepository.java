package org.obozek.filterlib;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ondrej.Bozek
 */
public interface FilteringRepository<T, F extends Pageable, P extends Page<T>>
{

    /**
     * Generic filtering of Entities using filter fields with names equal to
     * names of fields in Entity, filter fields which do not match fields in
     * Entity, can be individually treated by ad ding entries in to
     * registeredProcessors Map
     *
     * TODO add cache for pre-filter Predicates
     *
     * @param filter
     * @param T
     * @return
     * @throws IllegalAccessException
     */
    public P filter(F filter);
    /**
     * <p>Method adds Filter to the Map of pre-filters</p>
     *
     * <p>Pre filters are used for pre-filtering of results. These filters are
     * always utilized for all searches for matching entities.</p> Can be used
     * for: <ul> <li>row level security, </li> <li>multitenancy, </li>
     * <li>shared tables, </li> <li>soft deletes, </li> <li>data history,</li>
     * <li>temporal filtering </li> <li>etc...</li> </ul>
     *
     * If filter for provided class already existed, it will be replaced
     *
     * TODO QueryCriteria is not ideal preFilter ancestor should be replaced
     * with different class TODO add cache for pre-filter Predicates
     *
     * @param entityClass
     * @param criteria
     */
//    public <C extends Pageable> void addPreFilter(Class<?> entityClass, C criteria);
//
//    /**
//     * Remove filter for selected entity
//     *
//     * @param entityClass
//     */
//    public void removePreFilter(Class<?> entityClass);
}
