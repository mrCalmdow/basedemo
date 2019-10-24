package com.flchen.basedemo.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * author fl.chen
 * Date 2019-10-24
 * Time 16:44
 * Desc:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayQueueTest {

    @Data
    @AllArgsConstructor
    class Node {
        int key;
        String value;
    }

    @Test
    public void normalQueueUse() {

        ArrayQueue<Node> queue = new ArrayQueue<>();

        Node n1 = new Node(1, "n1");
        Node n2 = new Node(2, "n2");
        Node n3 = new Node(3, "n3");

        queue.enqueue(n1);
        queue.enqueue(n2);
        queue.enqueue(n3);

        Assert.isTrue(n1 == queue.dequeue(), "");
        Assert.isTrue(n2 == queue.dequeue(), "");
        Assert.isTrue(n3 == queue.dequeue(), "");

    }

    @Test
    public void emptyQueueShouldReturnNull() {

        ArrayQueue<Node> queue = new ArrayQueue<>();
        Assert.isTrue(null == queue.dequeue(), "");
    }

    @Test
    public void fullQueueCanNotEnqueue() {
        ArrayQueue<Node> queue = new ArrayQueue<>(3);
        Node n1 = new Node(1, "n1");
        Node n2 = new Node(2, "n2");
        Node n3 = new Node(3, "n3");
        Node n4 = new Node(4, "n4");

        queue.enqueue(n1);
        queue.enqueue(n2);
        queue.enqueue(n3);
        Assert.isTrue(false == queue.enqueue(n4), "");
    }

    @Test
    public void resourceResize() {
        ArrayQueue<Node> queue = new ArrayQueue<>(3);
        Node n1 = new Node(1, "n1");
        Node n2 = new Node(2, "n2");
        Node n3 = new Node(3, "n3");
        Node n4 = new Node(4, "n4");

        queue.enqueue(n1);
        queue.enqueue(n2);
        queue.enqueue(n3);

        Assert.isTrue(n1 == queue.dequeue(), "");
        Assert.isTrue(n2 == queue.dequeue(), "");
        Assert.isTrue(n3 == queue.dequeue(), "");

        Assert.isTrue(queue.enqueue(n4), "");
        Assert.isTrue(n4 == queue.dequeue(), "");
    }
}
