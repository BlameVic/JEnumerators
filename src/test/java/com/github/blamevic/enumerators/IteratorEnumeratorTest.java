package com.github.blamevic.enumerators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static com.github.blamevic.enumerators.ThrowableCaptor.captureThrowable;

public class IteratorEnumeratorTest
{
    List<String> testItems = Arrays.asList("String1", "String2", "", null, "", "String6");

    @Test
    public void testIteratorEnumeratorResult()
    {
        Enumerator<String> pureEnumerator = Enumerators.fromList(testItems);
        Enumerator<String> iterEnumerator = Enumerators.fromIterator(testItems.iterator());

        assertThat(iterEnumerator.current()).isEqualTo(pureEnumerator.current());

        while (pureEnumerator.moveNext())
        {
            assertThat(iterEnumerator.moveNext()).isTrue();

            assertThat(iterEnumerator.current()).isEqualTo(pureEnumerator.current());
        }

        String before = iterEnumerator.current();

        assertThat(before).isNotNull();

        assertThat(iterEnumerator.moveNext()).isFalse();
        assertThat(iterEnumerator.moveNext()).isFalse();

        assertThat(iterEnumerator.current()).isEqualTo(before);
    }

    @Test
    public void testEmptyIterator() throws Exception
    {
        Throwable exception = captureThrowable(() -> Enumerators.fromIterator(Arrays.asList().iterator()));

        assertThat(exception)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("The iterator has no elements");
    }

    @Test
    public void testReturnIterator() throws Exception
    {
        Iterator<String> iter = testItems.iterator();
        Enumerator<String> enumerator = Enumerators.fromIterator(iter);

        assertThat(enumerator.iterator() == iter).isTrue();
    }

    @Test
    public void testRemove() throws Exception
    {
        List<String> mutableItems = new ArrayList<>();
        mutableItems.add("String1");
        mutableItems.add("String2");
        mutableItems.add("String3");

        Enumerator<String> enumerator = Enumerators.fromIterator(mutableItems.iterator());

        assertThat(enumerator.current()).isEqualTo(testItems.get(0));

        enumerator.remove();

        Throwable exception = captureThrowable(enumerator::current);

        assertThat(exception)
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage("The current element has been removed");

        enumerator.moveNext();

        assertThat(enumerator.current()).isEqualTo("String2");

        enumerator.moveNext();
        enumerator.remove();
        enumerator.moveNext();

        exception = captureThrowable(enumerator::current);

        assertThat(exception)
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage("The current element has been removed");
    }
}

