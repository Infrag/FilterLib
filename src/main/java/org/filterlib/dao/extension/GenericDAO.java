package org.filterlib.dao.extension;

import org.filterlib.dao.FilteringRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ondrej.Bozek
 */
public interface GenericDAO<T extends EntityInterface, U extends Pageable, V> extends FilteringRepository<T, U, Page<T>>
{

    public T getEntity(V id);

    public void removeEntity(V id);

    public T saveEntity(T entity);
}