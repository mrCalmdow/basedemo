package com.flchen.basedemo.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * author: flchen
 * Date: 2019/10/13
 * Time: 8:59 PM
 *
 * @Description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LRUWithSingleLinkedTest {

    @Test
    public void testCapacityFixed() {
        int INITIAL_SIZE = 5;
        int LAST_ITEM = 100;
        LRUWithSingleLinked<Integer> lru = new LRUWithSingleLinked(INITIAL_SIZE);
        long startTime = System.currentTimeMillis();
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(1);
        lru.add(4);
        lru.add(1);
        lru.add(99);
        lru.add(1);
        lru.add(8);
        lru.add(LAST_ITEM);
        long endTime = System.currentTimeMillis();
        log.info("[Set Values] -- spend -{}", endTime - startTime);
        LRUWithSingleLinked<Integer>.Node<Integer> header = lru.getHeader();
        Assert.isTrue(LAST_ITEM == header.getValue());
        log.info("Len = {}", lru.getLen());
        log.info(lru.values().toString());
        Assert.isTrue(INITIAL_SIZE >= lru.getLen());
    }
}
