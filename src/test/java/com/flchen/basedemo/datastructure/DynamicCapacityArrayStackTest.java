package com.flchen.basedemo.datastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * author fl.chen
 * Date 2019-10-23
 * Time 09:21
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicCapacityArrayStackTest {

    @Data
    @AllArgsConstructor
    class Node {
        int key;
        String value;
    }
    @Test
    public void shouldAutoExpansion() {
        int SIZE = 21;
        int INIT = 4;
        DynamicCapacityArrayStack<Node> stack = new DynamicCapacityArrayStack<>(4);
        for (int i = 0; i < SIZE; i++) {
            Node n = new Node(i, "value" + i);
            stack.push(n);
        }
        Assert.isTrue(SIZE == stack.index, "");

        Node node = stack.pop();
        Assert.isTrue(node.getKey() == SIZE - 1, "");
    }
}
