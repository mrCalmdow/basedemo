package com.flchen.basedemo.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: flchen
 * Date: 2019/10/13
 * Time: 10:29 AM
 *
 * @Description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingleLinkedDemoTest {

    @Test
    public void testCreateLinkedSuccess() {
        SingleLinkedDemo<Integer> singleLinkedDemo = new SingleLinkedDemo<>();
        SingleLinkedDemo<Integer>.Node<Integer> header = singleLinkedDemo.new Node<Integer>();

        Integer[] sourceArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 9, 8};
        header = singleLinkedDemo.createLinkedList(sourceArray);
        int size = singleLinkedDemo.getSize();
        log.info("Now singleLinked size = {}", size);

        singleLinkedDemo.iterateLinkedList(header);
    }
}
