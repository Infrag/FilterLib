package org.filter.dao;

import javax.persistence.EntityManager;
import org.springframework.data.domain.Pageable;

/**
 * 
 *
 * @author Ondrej.Bozek
 */
public abstract class EntityManagerFilteringRepository<T, U extends Pageable> extends AbstractFilteringRepository<T, U>
{

    private EntityManager entityManager;

    public EntityManagerFilteringRepository(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    protected EntityManager getEm()
    {
        return entityManager;
    }
}