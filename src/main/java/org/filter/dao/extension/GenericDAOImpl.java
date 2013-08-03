package org.filter.dao.extension;

import org.filter.dao.CommonFilteringRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ondrej.Bozek
 */
public class GenericDAOImpl<T extends EntityInterface, U extends Pageable, V>
        extends CommonFilteringRepository<T, U> {

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDAOImpl() {
    }

    public T getEntity(V id) {
        Class<T> returned = returnedClass();
        System.out.println("Returned class: " + returned);
        return entityManager.find(returnedClass(), id);
    }

    public void removeEntity(V id) {
        entityManager.remove(entityManager.find(returnedClass(), id));
    }

    public T saveEntity(T entity) {
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
    protected EntityManager getEm() {
        return entityManager;
    }
}
