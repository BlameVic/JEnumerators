package com.github.blamevic.enumerators;

import java.util.Iterator;

public interface Enumerable<T> extends Iterable<T>
{
    /**
     * Returns an enumerator over elements of type {@code T}.
     *
     * @return an Enumerator.
     */
    Enumerator<T> enumerator();

    @Override
    default Iterator<T> iterator()
    {
        return Enumerators.toIterator(enumerator());
    }
}
