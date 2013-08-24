package org.filterlib.dao;

import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * T - represents entity type
 *
 * @author Ondrej.Bozek
 */
public interface ProcessorContext<T> extends FilterContext<T> {

    public Field getField();

    public Boolean isNegated();

    public StructuredPath getStructuredPath();

    public <U> Path<U> getPath();

    public List<Predicate> getAndPredicates();

    public List<Predicate> getOrPredicates();

    public Predicate addPredicate(Predicate predicate);

    public Boolean isNullEnforced();

    public Boolean shouldProcess(Object value);
}
