package com.github.blamevic.enumerators;

import java.util.Iterator;

class IteratorEnumerator<E> implements Enumerator<E>
{
    private Iterator<E> iterator;
    private E current;
    private boolean currentRemoved;

    public IteratorEnumerator(Iterator<E> iterator)
    {
        if (iterator.hasNext())
        {
            this.current = iterator.next();
        } else
        {
            throw new IllegalArgumentException("The iterator has no elements");
        }
        this.iterator = iterator;
    }

    @Override
    public E current()
    {
        if (currentRemoved) throw new IllegalStateException("The current element has been removed");

        return current;
    }

    @Override
    public boolean moveNext()
    {
        if (iterator.hasNext())
        {
            current = iterator.next();
            currentRemoved = false;
            return true;
        } else
            return false;
    }

    @Override
    public void remove()
    {
        currentRemoved = true;
        iterator.remove();
    }

    @Override
    public Iterator<E> iterator()
    {
        return iterator;
    }
}
