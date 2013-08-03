package org.filter.dao.defaultprocessors;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort.Order;

public class OrderingImpl implements Ordering
{

    private List<Order> orders;

    public List<Order> getOrders()
    {
        if (orders == null) {
            orders = new ArrayList<Order>();
        }
        return orders;
    }
}