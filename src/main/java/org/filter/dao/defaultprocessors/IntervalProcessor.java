package org.filter.dao.defaultprocessors;

import javax.persistence.criteria.CriteriaBuilder;
import org.filter.dao.ProcessorContext;

/**
 *
 * @author Ondrej.Bozek
 */
public class IntervalProcessor<T extends Comparable> implements ClassProcessor<Interval<T>> {

    @Override
    public void processCustomField(Interval<T> value, ProcessorContext<Object> processorContext) {
//        predicates.add(cb.like(cb.lower(navigate(field.getName(), FILTER_PATH_SEPARATOR, entity)), "%" + ((String) field.get(filter)).toLowerCase() + "%"));
        // there is some bound specified 
        if (value != null && (value.maxIsNotNull() || value.minIsNotNull())) {
            CriteriaBuilder cb = processorContext.getCriteriaBuilder();
            // there are both bounds specified 
            if (value.maxIsNotNull() && value.minIsNotNull()) {
                // check when upper and lower bounds are equal
                if (value.getMax().getValue().equals(value.getMin().getValue())) {
                    //if one of them is exclusive no result can be found
                    if (!value.getMax().isInclusive() || !value.getMin().isInclusive()) {
                        throw new IllegalArgumentException("Error, interval bounds are makeing it logically impossible to retrieve any result.");
                    }
                    processorContext.addPredicate(cb.equal(processorContext.getPath(),
                            value.getMax().getValue()));
                    return;
                }
                // Max is smaller than min
                if (value.getMax().getValue().compareTo(value.getMin().getValue()) < 0) {
                    throw new IllegalArgumentException("Error, interval bounds are makeing it logically impossible to retrieve any result.");
                }
            }

            // Add upper bound
            if (value.maxIsNotNull()) {
                if (value.getMax().isInclusive()) {
                    processorContext.addPredicate(cb.lessThanOrEqualTo(processorContext.<T>getPath(),
                            value.getMax().getValue()));
                } else {
                    processorContext.addPredicate(cb.lessThan(processorContext.<T>getPath(),
                            value.getMax().getValue()));
                }
            }
            // Add lower bound
            if (value.minIsNotNull()) {
                if (value.getMin().isInclusive()) {
                    processorContext.addPredicate(cb.greaterThanOrEqualTo(processorContext.<T>getPath(),
                            value.getMin().getValue()));
                } else {
                    processorContext.addPredicate(cb.greaterThan(processorContext.<T>getPath(),
                            value.getMin().getValue()));
                }
            }
        }
    }
}
