package org.obozek.filterlib;

/**
 *
 * @author Ondrej.Bozek
 */
public class Hint
{

    public String name;
    public Object value;

    public Hint(String name, Object value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }
}
