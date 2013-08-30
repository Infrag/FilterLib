package org.filterlib.dao;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.StringUtils;
import org.filterlib.dao.defaultprocessors.valueholders.BasicValueHolder;
import org.filterlib.dao.defaultprocessors.valueholders.CustomIgnoredValueException;
import org.filterlib.dao.defaultprocessors.valueholders.IgnoredValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessorContextImpl<P> extends FilterContextImpl<P> implements ProcessorContext<P> {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessorContextImpl.class);
    private List<Predicate> orPredicates;
    private List<Predicate> andPredicates;
    private Field field;
    private StructuredPath path = null;

    ProcessorContextImpl(List<Predicate> andPredicates, List<Predicate> orPredicates,
            Root<P> entity, Field field, CriteriaQuery<P> query,
            EntityManager entityManager, Object criteria) {
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

    /**
     * TODO This should be probably refactored to default abstract Processor
     *
     * @return
     */
    private Set<Object> getIgnoredValues() {
        IgnoredValues iv = field.getAnnotation(IgnoredValues.class);
        Class<? extends BasicValueHolder>[] ignoredValues = null;
        if (iv == null) {
            try {
                ignoredValues = (Class<? extends BasicValueHolder>[]) IgnoredValues.class
                        .getMethod(IgnoredValues.METHOD_NAME).getDefaultValue();
            } catch (NoSuchMethodException nsme) {
                LOG.error("System Error retrieving default ignored values", nsme);
                throw new RuntimeException("System Error retrieving default ignored values", nsme);
            }
        } else {
            ignoredValues = iv.values();
        }
        Set<Object> result = new HashSet<Object>();
        for (Class<? extends BasicValueHolder> class1 : ignoredValues) {
            try {
                result.add(class1.getDeclaredField(BasicValueHolder.VALUE_FIELD_NAME).get(null));
            } catch (Exception ex) {
                LOG.error("Error retrieving custom ignored field vales.", ex);
                throw new CustomIgnoredValueException("Error retrieving custom ignored field vales.", ex);
            }
        }
        return result;

    }

    /**
     * TODO This should be probably refactored to default abstract Processor
     *
     * Method decides if value should be processed by processor, it also takes
     * care about *null* values (instead of processor)
     *
     * @param value
     * @return
     */
    @Override
    public Boolean shouldProcess(Object value) {
        Set<Object> ignoredValues = getIgnoredValues();
        if (ignoredValues.contains(null) && value == null) {
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
        return !ignoredValues.contains(value);
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
