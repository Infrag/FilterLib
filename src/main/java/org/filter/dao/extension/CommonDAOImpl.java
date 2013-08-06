package org.filter.dao.extension;

import org.filter.dao.CommonFilteringRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ondrej.Bozek
 */
public class CommonDAOImpl<T extends EntityInterface, U extends Pageable, V>
        extends CommonFilteringRepository<T, U>
{

    @PersistenceContext(name = "DmvsPersisteceUnit")
    protected EntityManager entityManager;

    public CommonDAOImpl()
    {
    }

    public T getEntity(V id)
    {
        Class<T> returned = returnedClass();
        System.out.println("Returned class: " + returned);
        return entityManager.find(returnedClass(), id);
    }

    public void removeEntity(V id)
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

    @Override
    public <C extends Pageable> void addPreFilter(Class<?> entityClass, C criteria)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
