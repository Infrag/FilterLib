package org.filter.dao.defaultprocessors;

import java.util.ArrayList;
import org.filter.dao.ProcessorContext;
import java.util.Collection;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * Basic list processor for processing of list of values, it also processes null
 * value in Collections
 *
 * @author Ondrej.Bozek
 */
public class CollectionProcessor<T extends Comparable> implements ClassProcessor<Collection<T>>
{

    @Override
    public void processCustomField(Collection<T> value, ProcessorContext<Object> processorContext)
    {
        if (value != null && !value.isEmpty()) {
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
}
