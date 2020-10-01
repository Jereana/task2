package com.epam.rd.java.basic.practice2;
import org.junit.Assert;
import org.junit.Test;

public class StackImplTest {
    @Test
    public void testMe() {
        Assert.assertTrue(true);
        StackImpl stack = new StackImpl();
        stack.push("111");
        stack.push("112");
        Assert.assertEquals(2, stack.size());
    }
}
