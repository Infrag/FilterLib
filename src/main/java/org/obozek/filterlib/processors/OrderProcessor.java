package org.obozek.filterlib.processors;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import org.apache.commons.lang.StringUtils;
import org.obozek.filterlib.ProcessorContext;
import org.obozek.filterlib.StructuredPathFactory;
import org.obozek.filterlib.processors.valuerestrictions.BlankOrderValueRestriction;
import org.obozek.filterlib.processors.valuerestrictions.ValueRestriction;
import org.springframework.data.domain.Sort.Order;

/**
 * Processor responsible for single ordering of query
 *
 * @author Ondrej.Bozek
 */
public class OrderProcessor extends AbstractClassProcessor<Order> {

    public static final String ORDER_PATH_SEPARATOR = ".";
    private static final Class[] DEFAULT_IGNORED_VALUES_RESTRICTIONS = {BlankOrderValueRestriction.class};

    @Override
    protected Class<? extends ValueRestriction>[] getDefaultIgnoredValueRestrictions() {
        return DEFAULT_IGNORED_VALUES_RESTRICTIONS;
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
    private javax.persistence.criteria.Order getOrdering(Order order, ProcessorContext<Object> processorContext, CriteriaBuilder cb) {
        javax.persistence.criteria.Order result = null;
        if (order != null && StringUtils.isNotEmpty(order.getProperty())) {
            Path path = StructuredPathFactory.navigate(order.getProperty(), ORDER_PATH_SEPARATOR, processorContext.getEntityRoot()).getPath();
            result = order.isAscending() ? cb.asc(path) : cb.desc(path);
        }
        return result;
    }

    @Override
    protected void processRelevantField(Order value, ProcessorContext<Object> processorContext) {
        CriteriaBuilder cb = processorContext.getEntityManager().getCriteriaBuilder();
        List<javax.persistence.criteria.Order> orders = processorContext.getCriteriaQuery().getOrderList();
        if (orders == null) {
            orders = new ArrayList<javax.persistence.criteria.Order>();
        }
        orders.add(getOrdering(value, processorContext, cb));
        processorContext.getCriteriaQuery().orderBy(orders);
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