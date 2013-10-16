package org.obozek.filterlib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FilterContextImpl<T> implements FilterContext<T>
{

    private Object criteria;
    private Root<T> entity;
    private CriteriaQuery<T> query;
    private EntityManager entityManager;
    private List<Hint> hints;

    FilterContextImpl(Root<T> entity, CriteriaQuery<T> query, EntityManager entityManager, Object criteria)
    {
        this.entity = entity;
        this.entityManager = entityManager;
        this.query = query;
        this.criteria = criteria;
    }

    ProcessorContext<T> getProcessorContext(List<Predicate> andPredicates, List<Predicate> orPredicates, Field field)
    {
        return new ProcessorContextImpl<T>(andPredicates, orPredicates, entity, field, query, entityManager, criteria);
    }

    @Override
    public Root<T> getEntityRoot()
    {
        return entity;
    }

    @Override
    public CriteriaQuery<T> getCriteriaQuery()
    {
        return query;
    }

    @Override
    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder()
    {
        return entityManager.getCriteriaBuilder();
    }

    @Override
    public List<Hint> getHints()
    {
        if (hints == null) {
            hints = new ArrayList<Hint>();
        }
        return hints;
    }
}
