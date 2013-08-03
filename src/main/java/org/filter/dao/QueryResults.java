package org.filter.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ondrej.Bozek
 */
public class QueryResults<T> implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int totalCount;
    private List<T> items;

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public List<T> getItems()
    {
        return items;
    }

    public void setItems(List<T> items)
    {
        this.items = items;
    }
}
