package org.filterlib.dao.defaultprocessors;

import org.filterlib.dao.ProcessorContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author Ondrej.Bozek
 */
public class StringLikeProcessor implements ClassProcessor<String> {

    @Override
    public void processCustomField(String value, ProcessorContext<Object> processorContext) {
        if (processorContext.shouldProcess(value)) {
            CriteriaBuilder cb = processorContext.getEntityManager().getCriteriaBuilder();
            Predicate p;
            p = cb.like(cb.lower(processorContext.<String>getPath()), "%" + (value).toLowerCase() + "%");
            processorContext.addPredicate(p);
        }
    }
}
