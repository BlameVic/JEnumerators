package com.github.blamevic.enumerators;

import java.util.Iterator;
import java.util.NoSuchElementException;

class EnumeratorIterator<E> implements Iterator<E>
{
    private Enumerator<E> enumerator;
    private E next;
    private boolean hasNext;

    public EnumeratorIterator(Enumerator<E> enumerator)
    {
        this.enumerator = enumerator;

        this.next = enumerator.current();
        this.hasNext = true;
    }

    @Override
    public boolean hasNext()
    {
        setNext();

        return hasNext;
    }

    @Override
    public E next()
    {
        setNext();

        if (!hasNext) throw new NoSuchElementException();

        hasNext = false;
        return next;
    }

    private void setNext()
    {
        if (hasNext) return;

        if (enumerator.moveNext())
        {
            this.next = enumerator.current();
            hasNext = true;
        }
    }
}
