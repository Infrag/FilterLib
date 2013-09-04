package org.obozek.filterlib.processors;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import org.obozek.filterlib.ProcessorContext;
import org.obozek.filterlib.processors.valuerestrictions.EmptyCollectionValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.ValueRestriction;

/**
 * Basic list processor for processing of list of values, it also processes null
 * value in Collections
 *
 * @author Ondrej.Bozek
 */
public class CollectionProcessor<T extends Comparable> extends AbstractClassProcessor<Collection<T>> {

    private static final Class[] DEFAULT_IGNORED_VALUES_RESTRICTIONS = {EmptyCollectionValueRestriction.class};

    /**
     * Method returns values which are defaultly ignored default implementation
     * ignores nulls
     *
     * @return
     */
    @Override
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        return DEFAULT_IGNORED_VALUES_RESTRICTIONS;

    }

    @Override
    protected void processRelevantField(Collection<T> value, ProcessorContext<Object> processorContext) {
        Predicate p;
        Path path = processorContext.getPath();
        if (value.contains(null)) {
            value = new ArrayList<T>(value);
            value.remove(null);
            p = processorContext.getCriteriaBuilder().or(path.in(value), path.isNull());
        } else {
            p = path.in(value);
        }
        processorContext.addPredicate(p);
    }
}
