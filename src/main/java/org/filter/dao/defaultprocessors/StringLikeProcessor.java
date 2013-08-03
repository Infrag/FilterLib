package org.filter.dao.defaultprocessors;

import org.filter.dao.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author Ondrej.Bozek
 */
public class StringLikeProcessor implements ClassProcessor<String>
{

    public void processCustomField(String value, ProcessorContext<Object> processorContext)
    {
        if (processorContext.shouldProcess(value)) {
            CriteriaBuilder cb = processorContext.getEntityManager().getCriteriaBuilder();
            Predicate p;
            p = cb.like(cb.lower(processorContext.getPath()), "%" + (value).toLowerCase() + "%");
            processorContext.addPredicate(p);
        }
    }
}
