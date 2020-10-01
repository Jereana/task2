package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Test;

public class ArrayImplTest {
    @Test
    public void testMe() {
        Assert.assertTrue(true);
        ArrayImpl array = new ArrayImpl(2);
        array.add("111");
        array.add("112");
        Assert.assertEquals(2, array.size());
        Assert.assertTrue(array.get(1).equals("112"));
    }
    
}
