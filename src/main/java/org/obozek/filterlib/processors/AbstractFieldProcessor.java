/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.processors;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import org.obozek.filterlib.CustomFieldProcessor;
import org.obozek.filterlib.ProcessorContext;
import org.obozek.filterlib.processors.valuerestrictions.BasicValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.CustomIgnoredValueException;
import org.obozek.filterlib.processors.valuerestrictions.IgnoredValues;
import org.obozek.filterlib.processors.valuerestrictions.ValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.ZeroLongValueRestriction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default bootstrap implementation of CustomFieldProcessor to provide some
 * basic methods and support common Field Processing behavior
 *
 * @author infragile
 */
public abstract class AbstractFieldProcessor<T extends Object, V> implements CustomFieldProcessor<T, V> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractFieldProcessor.class);
    protected static final Map<String, ValueRestriction> VALUE_RESTRICTION_CACHE = new HashMap<String, ValueRestriction>();

    static {
        addValueRestrictionToCache(new ZeroLongValueRestriction());
        addValueRestrictionToCache(new BasicValueRestriction());
    }

    /**
     * Method adds value restriction object to cache for faster access
     *
     * @param restriction
     */
    public static void addValueRestrictionToCache(ValueRestriction restriction) {
        VALUE_RESTRICTION_CACHE.put(restriction.getClass().getName(), restriction);
    }

    /**
     * Method adds value restriction object to cache for faster access
     *
     * @param restriction
     */
    public static ValueRestriction getValueRestriction(Class<? extends ValueRestriction> restriction)
            throws InstantiationException, IllegalAccessException {
        ValueRestriction result = VALUE_RESTRICTION_CACHE.get(restriction.getName());
        if (result == null) {
            result = restriction.newInstance();
            addValueRestrictionToCache(result);
        }
        return result;
    }

    /**
     * Method returns values which are defaultly ignored default implementation
     * ignores nulls
     *
     * @return
     */
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        try {
            return (Class<? extends ValueRestriction>[]) IgnoredValues.class
                    .getMethod(IgnoredValues.METHOD_NAME).getDefaultValue();
        } catch (NoSuchMethodException nsme) {
            LOG.error("System Error retrieving default ignored values", nsme);
            throw new RuntimeException("System Error retrieving default ignored values", nsme);
        }
    }

    /**
     * Method retrieves values which are ignored on this field
     *
     * @return
     */
    private Boolean isValueIgnored(V value, ProcessorContext<T> processorContext) {
        IgnoredValues iv = processorContext.getField().getAnnotation(IgnoredValues.class);
        Class<? extends ValueRestriction>[] ignoredValues;
        if (iv == null) {
            ignoredValues = getDefaultIgnoredValueRestrictions();
        } else {
            ignoredValues = iv.values();
        }
        for (Class<? extends ValueRestriction> class1 : ignoredValues) {
            try {
                if (getValueRestriction(class1).isValueIgnored(value)) {
                    return true;
                }
            } catch (Exception ex) {
                LOG.error("Error retrieving custom ignored field vales.", ex);
                throw new CustomIgnoredValueException("Error retrieving custom ignored field vales.", ex);
            }
        }
        return false;

    }

    /**
     * Method decides if value should be processed by processor, it also takes
     * care about *null* values (instead of processor)
     *
     * @param value
     * @return
     */
    protected Boolean shouldProcess(V value, ProcessorContext<T> processorContext) {
        Boolean valueIgnored = isValueIgnored(value, processorContext);
        if (!valueIgnored && value == null) {
            handleNullValues(value, processorContext);
            return false;
        }
        return !valueIgnored;
    }

    /**
     * Method for handling null value comparison corner case
     *
     * @param value
     * @param processorContext
     */
    protected void handleNullValues(V value, ProcessorContext<T> processorContext) {
        CriteriaBuilder cb = processorContext.getCriteriaBuilder();
//            Predicate p;
//            if (isNegated()) {
//                p = cb.isNotNull(getPath());
//            } else {
//                p = cb.isNull(getPath());
//            }
        Predicate p = cb.isNull(processorContext.getPath());
        processorContext.addPredicate(p);
    }

    @Override
    public void processCustomField(V value, ProcessorContext<T> processorContext) {
        if (shouldProcess(value, processorContext)) {
            processRelevantField(value, processorContext);
        }
    }

    protected abstract void processRelevantField(V value, ProcessorContext<T> processorContext);
}
