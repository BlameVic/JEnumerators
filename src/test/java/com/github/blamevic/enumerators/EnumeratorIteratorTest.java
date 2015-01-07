package com.github.blamevic.enumerators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class EnumeratorIteratorTest
{
    final String[] testItems = {"String1", "String2", "", null, "", "String6"};
    @Test
    public void testIteratorEnumerator() throws Exception
    {
        Iterator<String> pureIter = Arrays.asList(testItems).iterator();
        Iterator<String> enumeratorIter = Enumerators.toIterator(Enumerators.fromArray(testItems));

        while (pureIter.hasNext())
        {
            assertThat(enumeratorIter.hasNext()).isTrue();

            assertThat(enumeratorIter.next()).isEqualTo(pureIter.next());
        }
    }
}
