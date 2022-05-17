package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests
{
    @Test
    public void testStringInputEmpty()
    {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    public void testPositiveNegativeNonSign()
    {
        Assertions.assertEquals(1, Integer.decode("1"));
        Assertions.assertEquals(-1, Integer.decode("-1"));
        Assertions.assertEquals(1, Integer.decode("+1"));
    }

    @Test
    public void testHexadecimalInput()
    {
        Assertions.assertEquals(21, Integer.decode("0x15"));
        Assertions.assertEquals(21, Integer.decode("0X15"));
        Assertions.assertEquals(21, Integer.decode("#15"));
    }

    @Test
    public void testOctalInput()
    {
        Assertions.assertEquals(21, Integer.decode("025"));
    }

    @Test
    public void testSignCharacterInWrongPosition()
    {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("++5"));
    }

    @Test
    public void testRandomStringInput()
    {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("Hello world!"));
    }

    @Test
    public void testMinValue()
    {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(String.format("%d", Integer.MIN_VALUE)));
    }

    @Test
    public void testMaxValue()
    {
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(String.format("%d", Integer.MAX_VALUE)));
    }
}
