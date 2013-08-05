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
public class SortProcessor implements ClassProcessor<Sort>
{

    private OrderProcessor orderProcessor;

    public SortProcessor(OrderProcessor processor)
    {
        orderProcessor = processor;
    }

    @Override
    public void processCustomField(Sort value, ProcessorContext<Object> processorContext)
    {
        if (value != null) {
            Iterator<Order> iterator = value.iterator();
            while (iterator.hasNext()) {
                orderProcessor.processCustomField(iterator.next(), processorContext);
            }
        }
    }
}
