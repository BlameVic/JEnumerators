package com.github.blamevic.enumerators;

public class NullEnumerator<E> implements Enumerator<E>
{
    @Override
    public E current()
    {
        return null;
    }

    @Override
    public boolean moveNext()
    {
        return false;
    }
}
