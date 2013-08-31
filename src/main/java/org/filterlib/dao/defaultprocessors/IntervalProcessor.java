package org.filterlib.dao.defaultprocessors;

import javax.persistence.criteria.CriteriaBuilder;
import org.filterlib.dao.ProcessorContext;
import org.filterlib.dao.defaultprocessors.valuerestrictions.IntervalValueRestriction;
import org.filterlib.dao.defaultprocessors.valuerestrictions.ValueRestriction;

/**
 *
 * @author Ondrej.Bozek
 */
public class IntervalProcessor<T extends Comparable> extends AbstractClassProcessor<Interval<T>> {

    private static final Class[] DEFAULT_IGNORED_VALUES_RESTRICTIONS = {IntervalValueRestriction.class};

    @Override
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        return DEFAULT_IGNORED_VALUES_RESTRICTIONS;
    }

    @Override
    protected void processRelevantField(Interval<T> value, ProcessorContext<Object> processorContext) {
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
