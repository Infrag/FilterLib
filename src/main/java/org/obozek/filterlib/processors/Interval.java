package org.obozek.filterlib.processors;

/**
 * Class used to specify bounds for Comparable type. Defults to inclusive bounds
 * if not specified otherwise.
 *
 * @author Ondrej.Bozek
 */
public class Interval<T extends Comparable>
{

    private Value<T> max;
    private Value<T> min;

    public Interval()
    {
    }

    /**
     * Defults to inclusive bounds if not specified otherwise.
     *
     * @param maxVal - max bound
     * @param minVal - min bound
     */
    public Interval(T minVal, T maxVal)
    {
        this.max = new Value<T>(maxVal);
        this.min = new Value<T>(minVal);
    }

    /**
     *
     * @param maxVal
     * @param maxInclusive
     * @param minVal
     * @param minInclusive
     */
    public Interval(T minVal, boolean minInclusive, T maxVal, boolean maxInclusive)
    {
        this.max = new Value<T>(maxVal, maxInclusive);
        this.min = new Value<T>(minVal, minInclusive);
    }

    public static class Value<T extends Comparable>
    {

        private T value;
        private boolean inclusive = true;

        /**
         * Provided value Inclusive=true
         *
         * @param value
         */
        public Value(T value)
        {
            this.value = value;
        }

        public Value(T value, boolean inclusive)
        {
            this(value);
            this.inclusive = inclusive;
        }

        public T getValue()
        {
            return value;
        }

        public void setValue(T value)
        {
            this.value = value;
        }

        public boolean isInclusive()
        {
            return inclusive;
        }

        public void setInclusive(boolean inclusive)
        {
            this.inclusive = inclusive;
        }

        @Override
        public int hashCode()
        {
            int hash = 5;
            hash = 73 * hash + (this.value != null ? this.value.hashCode() : 0);
            hash = 73 * hash + (this.inclusive ? 1 : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Value<T> other = (Value<T>) obj;
            if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
                return false;
            }
            if (this.inclusive != other.inclusive) {
                return false;
            }
            return true;
        }
    }

    public boolean maxIsNotNull()
    {
        return getMax() != null && getMax().getValue() != null;
    }

    public boolean minIsNotNull()
    {
        return getMin() != null && getMin().getValue() != null;
    }

    public Value<T> getMax()
    {
        return max;
    }

    public void setMax(Value<T> max)
    {
        this.max = max;
    }

    public Value<T> getMin()
    {
        return min;
    }

    public void setMin(Value<T> min)
    {
        this.min = min;
    }
}
