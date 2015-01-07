package com.github.blamevic.enumerators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Enumerators
{
    private Enumerators() {}

    /**
     * Converts an {@code Enumerator<T>} to an {@code Iterator<T>}
     *
     * @param enumerator an enumerator
     * @param <T>        the base type of the enumerator and iterator
     * @return an iterator from the enumerator
     */
    public static <T> Iterator<T> toIterator(Enumerator<T> enumerator)
    {
        return new EnumeratorIterator<>(Objects.requireNonNull(enumerator));
    }

    /**
     * Converts an {@code Iterator<T>} to an {@code Enumerator<T>}
     *
     * @param iterator an iterator
     * @param <T>      the base type of the enumerator and iterator
     * @return an enumerator from the iterator
     */
    public static <T> Enumerator<T> fromIterator(Iterator<T> iterator)
    {
        return new IteratorEnumerator<>(Objects.requireNonNull(iterator));
    }

    /**
     * Converts an {@code List<T>} to an {@code Enumerator<T>}
     *
     * @param list a list
     * @param <T>  the base type of the list and enumerator
     * @return an enumerator from the list
     */
    public static <T> Enumerator<T> fromList(List<T> list)
    {
        return new ListEnumerator<>(Objects.requireNonNull(list));
    }

    @SafeVarargs
    public static <T> Enumerator<T> fromArray(final T... members)
    {
        return fromList(Arrays.asList(members));
    }
}
