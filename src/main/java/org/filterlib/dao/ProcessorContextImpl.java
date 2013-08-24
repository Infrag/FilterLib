package org.filterlib.dao;

import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;

public class ProcessorContextImpl<P> extends FilterContextImpl<P> implements ProcessorContext<P> {

    private List<Predicate> orPredicates;
    private List<Predicate> andPredicates;
    private Field field;
    private StructuredPath path = null;

    ProcessorContextImpl(List<Predicate> andPredicates, List<Predicate> orPredicates,
            Root<P> entity, Field field, CriteriaQuery<P> query,
            EntityManager entityManager, Pageable criteria) {
        super(entity, query, entityManager, criteria);
        this.field = field;
        this.andPredicates = andPredicates;
        this.orPredicates = orPredicates;
    }

    protected void preparePath() {
        FieldPath fieldPathAnnotation = field.getAnnotation(FieldPath.class);
        if (fieldPathAnnotation != null && StringUtils.isNotBlank(fieldPathAnnotation.value())) {
            path = StructuredPathFactory.navigate(fieldPathAnnotation.value(), FieldPath.FIELD_PATH_SEPARATOR, getEntityRoot());
        } else {
            path = StructuredPathFactory.navigate(getField().getName(), getEntityRoot());
        }
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public StructuredPath getStructuredPath() {
        if (path == null) {
            preparePath();
        }
        return path;
    }

    @Override
    public Path getPath() {
        return getStructuredPath().getPath();
    }

    @Override
    public Boolean isNegated() {
        return field.getAnnotation(Not.class) != null;
    }

    /**
     * This method adds provided predicate among used predicates, it also
     * automatically **negates** this predicate if other processed field is
     * signed as negated!!
     *
     * @param predicate
     * @return
     */
    @Override
    public Predicate addPredicate(Predicate predicate) {
        if (isNegated()) {
            predicate = predicate.not();
        }
        if (isDisjunct() || field.getAnnotation(Or.class) != null) {
            orPredicates.add(predicate);
        } else {
            andPredicates.add(predicate);
        }
        return predicate;
    }

    @Override
    public Boolean isNullEnforced() {
        return field.getAnnotation(ForceNull.class) != null;
    }

    @Override
    public Boolean shouldProcess(Object value) {
        if (value == null && isNullEnforced()) {
            CriteriaBuilder cb = getCriteriaBuilder();

//            Predicate p;
//            if (isNegated()) {
//                p = cb.isNotNull(getPath());
//            } else {
//                p = cb.isNull(getPath());
//            }
            Predicate p = cb.isNull(getPath());
            addPredicate(p);
            return false;
        }
        return value != null;
    }

    @Override
    public List<Predicate> getOrPredicates() {
        return orPredicates;
    }

    @Override
    public List<Predicate> getAndPredicates() {
        return andPredicates;
    }
}
