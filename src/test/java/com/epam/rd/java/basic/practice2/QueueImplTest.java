package com.epam.rd.java.basic.practice2;
import org.junit.Assert;
import org.junit.Test;

public class QueueImplTest {
 @Test
    public void testMe() {
        Assert.assertTrue(true);
        QueueImpl queue = new QueueImpl();
        queue.enqueue("111");
        queue.enqueue("112");
        Assert.assertEquals(2, queue.size());
    }

}
