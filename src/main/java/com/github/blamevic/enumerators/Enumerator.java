package com.github.blamevic.enumerators;

import java.util.Iterator;

/**
 * An object that implements the Enumerator interface provides a
 * series of elements, one at a time. The Enumerator starts at the
 * first item of the series. An Enumerator should not be generated
 * until the first element is known. Calls to the {@code moveNext()}
 * method advance the Enumerator to the next element in the sequence.
 *
 * @param <E> the type of elements returned by this iterator
 * @see java.util.Iterator
 */
public interface Enumerator<E> extends Iterable<E>
{
    /**
     * @return the current item in the collection
     *
     * @throws java.lang.IllegalStateException when the current element has been removed
     */
    public abstract E current();

    /**
     * Moves the Enumerator to the next item in the collection
     *
     * @return whether the Enumerator can move to the next item
     */
    public abstract boolean moveNext();

    /**
     * Removes from the underlying collection the current element of
     * this Enumerator (optional operation). This method can be called
     * only once per item. The behavior of an enumerator is unspecified
     * if the underlying collection is modified while the iteration is
     * in progress in any way other than by calling this method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code remove} method
     *                                       has already been called on this element.
     */
    default void remove()
    {
        throw new UnsupportedOperationException("remove");
    }

    /**
     * Resets the Enumerator to the beginning of the collection
     *
     * @throws java.lang.UnsupportedOperationException when the reset
     *                                                 operation is not supported by the underlying collection
     */
    default void reset()
    {
        throw new UnsupportedOperationException("reset");
    }

    /**
     * @see java.lang.Iterable
     */
    @Override
    default Iterator<E> iterator()
    {
        return Enumerators.toIterator(this);
    }
}
