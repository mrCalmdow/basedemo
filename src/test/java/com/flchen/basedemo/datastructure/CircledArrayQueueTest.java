package com.flchen.basedemo.datastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * author fl.chen
 * Date 2019-10-24
 * Time 21:59
 * Desc:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CircledArrayQueueTest {

    @Test
    public void normallyQueue() {

        /**
         * 循环队列，需要牺牲一个元素空间
         */
        CircledArrayQueue<String> queue = new CircledArrayQueue<>(6);   //实际只能存放5个元素
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        Assert.isTrue(false == queue.enqueue("6"), "");
        Assert.notNull(queue.dequeue());
        Assert.notNull(queue.dequeue());
        Assert.notNull(queue.dequeue());
        Assert.notNull(queue.dequeue());
        Assert.notNull(queue.dequeue());
        Assert.isNull(queue.dequeue());
    }
}
