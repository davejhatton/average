package com.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AveragerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAverager() {

        int[] numbers = {1, 7};
        assertEquals(4, Averager.getAverage(numbers));
    }

    @Test
    public void testStreamAverager() {

        int[] numbers = {1, 7};
        Averager.getAvererageStream(numbers).ifPresent(r -> assertEquals(4, r, 0.0));
    }


    @Test
    public void testMaxValue() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        Averager.getAvererageStream(numbers).ifPresent(r -> assertEquals((-2147483647 + 2147483647) / 2, r, 0.5));
    }

    @Test
    public void testNullArray() {
        int[] numbers = null;
        this.expectedException.expect(NullPointerException.class);
        Averager.getAvererageStream(numbers).getAsDouble();
    }
}
