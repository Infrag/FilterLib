package org.filter.dao.defaultprocessors;


import org.filter.dao.ProcessorContext;
import org.filter.dao.StructuredPathFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort.Order;

/**
 * Processor responsible for single ordering of query
 *
 * @author Ondrej.Bozek
 */
public class OrderProcessor implements ClassProcessor<Order>
{

    public static final String ORDER_PATH_SEPARATOR = ".";

    @Override
    public void processCustomField(Order value, ProcessorContext<Object> processorContext)
    {
        // ordering
        if (value != null && StringUtils.isNotBlank(value.getProperty())) {
            CriteriaBuilder cb = processorContext.getEntityManager().getCriteriaBuilder();
            processorContext.getCriteriaQuery().orderBy(getOrdering(value, processorContext, cb));
        }
    }

    /**
     * Method returns list of Orderers for ordering of criteria query, if not
     * enough ordering criteria provided, returns empty list
     *
     * @param order
     * @param startingPoint
     * @param cb
     * @return
     */
    private List<javax.persistence.criteria.Order> getOrdering(Order order, ProcessorContext<Object> processorContext, CriteriaBuilder cb)
    {
        List<javax.persistence.criteria.Order> result = new ArrayList<javax.persistence.criteria.Order>();
        if (order != null && StringUtils.isNotEmpty(order.getProperty())) {
            Path path = StructuredPathFactory.navigate(order.getProperty(), ORDER_PATH_SEPARATOR, processorContext.getEntityRoot()).getPath();
            result.add(order.isAscending()
                    ? cb.asc(path)
                    : cb.desc(path));
        }
        return result;
    }
}
// sort also by @Id field because of sorting bug in eclipselink and 
// Oracle - https://bugs.eclipse.org/bugs/show_bug.cgi?id=330027
//            String fieldName = "";
//            try {
//                // Common ID field name
//                T.getDeclaredField(ID_FIELD);
//                fieldName = ID_FIELD;
//                result.add(cb.asc(startingPoint.get(fieldName)));
//
//            } catch (NoSuchFieldException noSuchFieldException) {
//                // Uncommon field name -> have to find ID field name
//                Field id = getFieldWithAnnotation(T, Id.class);
//                if (id != null) {
//                    fieldName = id.getName();
//                    result.add(cb.asc(startingPoint.get(fieldName)));
//                }
//            }