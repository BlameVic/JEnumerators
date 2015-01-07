package com.github.blamevic.enumerators;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.*;

public class EnumeratorTest
{
    Enumerator nullEnumerator;
    Enumerator<String> notNullEnumerator;

    @Before
    public void setUp() throws Exception
    {
        nullEnumerator = new NullEnumerator<>();
        notNullEnumerator = Enumerators.fromArray("String1");

        unsupportedOperationException.reportMissingExceptionWithMessage("Expected UnsupportedOperationException to be thrown.");
    }

    @Test
    public void testRemove() throws Exception
    {
        unsupportedOperationException.expect(UnsupportedOperationException.class);
        nullEnumerator.remove();
    }

    @Test
    public void testReset() throws Exception
    {
        unsupportedOperationException.expect(UnsupportedOperationException.class);
        nullEnumerator.reset();
    }

    @Test
    public void testIterator() throws Exception
    {
        assertThat(notNullEnumerator.iterator())
                .containsExactlyElementsOf(() -> Enumerators.toIterator(notNullEnumerator));
    }

    @Rule
    public ExpectedException unsupportedOperationException = ExpectedException.none();
}

