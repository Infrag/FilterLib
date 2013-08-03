package org.filter.dao.defaultprocessors;

import org.filter.dao.ProcessorContext;
import java.util.Iterator;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 * For processing multiple orderings
 *
 * @author Ondrej.Bozek
 */
public class OrderingProcessor implements ClassProcessor<Sort> {

    private OrderProcessor orderProcessor;

    public OrderingProcessor(OrderProcessor processor) {
        orderProcessor = processor;
    }

    public void processCustomField(Sort value, ProcessorContext<Object> processorContext) {
        if (value != null) {
            Iterator<Order> iterator = value.iterator();
            while (iterator.hasNext()) {
                orderProcessor.processCustomField(iterator.next(), processorContext);
            }
        }
    }
}
