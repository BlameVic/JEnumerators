package com.github.blamevic.enumerators;

import java.util.List;

class ListEnumerator<E> implements Enumerator<E>
{
    List<E> list;
    int position;

    public ListEnumerator(List<E> list)
    {
        if (list.size() == 0) throw new IllegalArgumentException("The list has no elements");
        this.list = list;
        this.position = 0;
    }

    @Override
    public E current()
    {
        return list.get(position);
    }

    @Override
    public boolean moveNext()
    {
        if (position + 1 >= list.size()) return false;
        position++;
        return true;
    }
}
