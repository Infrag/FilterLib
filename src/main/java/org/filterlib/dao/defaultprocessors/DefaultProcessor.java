package org.filterlib.dao.defaultprocessors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.filterlib.dao.AbstractFilteringRepository;
import org.filterlib.dao.ProcessorContext;
import org.filterlib.dao.StructuredPath;
import org.filterlib.dao.StructuredPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ondrej.Bozek
 */
public class DefaultProcessor implements ClassProcessor<Object>
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultProcessor.class);

    @Override
    public void processCustomField(Object value, ProcessorContext<Object> processorContext)
    {
        if (processorContext.shouldProcess(value)) {
            CriteriaBuilder cb = processorContext.getCriteriaBuilder();

            StructuredPath<String> path = processorContext.getStructuredPath();
            Root<Object> root = processorContext.getEntityRoot();
            Class javaType = root.getJavaType();
            try {
                String firstLevel = path.getPathLevels().get(0);
                // move this to structured path
                if (AbstractFilteringRepository.getInheritedPrivateField(javaType, firstLevel).getType().isInstance(Collection.class)) {
                    Join<Object, Object> join = root.join(firstLevel);
                    List<String> levels = new ArrayList<String>(path.getPathLevels());
                    levels.remove(0);
                    path = StructuredPathFactory.navigate(levels, join);
                }
                Predicate p;
                p = cb.equal(path.getPath(), value);
                processorContext.addPredicate(p);
            } catch (NoSuchFieldException nsfe) {
                LOG.error("Error testing for multivalued relationship!", nsfe);
                throw new RuntimeException("Error testing for multivalued relationship!", nsfe);
            }
        }
    }
}
