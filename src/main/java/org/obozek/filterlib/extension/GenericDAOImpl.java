package org.obozek.filterlib.extension;

import org.obozek.filterlib.CommonFilteringRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ondrej.Bozek
 */
public class GenericDAOImpl<T extends EntityInterface<ID>, U extends Pageable, ID>
        extends CommonFilteringRepository<T, U>
{

    private static final Logger LOG = LoggerFactory.getLogger(GenericDAOImpl.class);
    @PersistenceContext
    protected EntityManager entityManager;
    private PreFilterAccessor preFilterAccessor;

    public GenericDAOImpl()
    {
    }

    public T getEntity(ID id)
    {
        Class<T> returned = returnedClass();
        LOG.debug("Returned class: " + returned);
        return entityManager.find(returnedClass(), id);
    }

    public void removeEntity(ID id)
    {
        entityManager.remove(entityManager.find(returnedClass(), id));
    }

    public T saveEntity(T entity)
    {
        T result = null;
        if (entity.getId() == null) {
            entityManager.persist(entity);
            result = entity;
        } else {
            result = entityManager.merge(entity);
        }
        return result;
    }

    @Override
    protected EntityManager getEm()
    {
        return entityManager;
    }
}
