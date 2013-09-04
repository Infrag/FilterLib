package org.obozek.filterlib.processors;


import java.util.List;
import org.springframework.data.domain.Sort.Order;

/**
 *
 * @author Ondrej.Bozek
 */
public interface Ordering
{

    public List<Order> getOrders();
}
