package org.obozek.filterlib.dao;

import java.io.Serializable;

/**
 *
 * @author Ondrej.Bozek
 */
public interface EntityInterface<T> extends Serializable
{

    public T getId();

    public void setId(T id);
}
