package org.filter.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ondrej.Bozek
 */
public interface FilterContext<T>
{

    public Root<T> getEntityRoot();

    public CriteriaQuery<T> getCriteriaQuery();

    public EntityManager getEntityManager();

    public CriteriaBuilder getCriteriaBuilder();

    public List<Hint> getHints();

    public Boolean isDisjunct();
}