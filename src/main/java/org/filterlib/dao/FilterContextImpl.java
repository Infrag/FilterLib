package org.filterlib.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;

public class FilterContextImpl<T> implements FilterContext<T>
{

    private Pageable criteria;
    private Root<T> entity;
    private CriteriaQuery<T> query;
    private EntityManager entityManager;
    private List<Hint> hints;

    FilterContextImpl(Root<T> entity, CriteriaQuery<T> query, EntityManager entityManager, Pageable criteria)
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

    public Root<T> getEntityRoot()
    {
        return entity;
    }

    public CriteriaQuery<T> getCriteriaQuery()
    {
        return query;
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public CriteriaBuilder getCriteriaBuilder()
    {
        return entityManager.getCriteriaBuilder();
    }

    public List<Hint> getHints()
    {
        if (hints == null) {
            hints = new ArrayList<Hint>();
        }
        return hints;
    }

    public Boolean isDisjunct()
    {
        return criteria.getClass().getAnnotation(Or.class) != null;
    }
}
