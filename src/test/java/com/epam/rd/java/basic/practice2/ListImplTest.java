package com.epam.rd.java.basic.practice2;
import org.junit.Assert;
import org.junit.Test;

public class ListImplTest {
    @Test
    public void testMe() {
        Assert.assertTrue(true);
        ListImpl list = new ListImpl();
        list.addFirst("111");
        list.addFirst("112");
        Assert.assertEquals(2, list.size());
    }

}
