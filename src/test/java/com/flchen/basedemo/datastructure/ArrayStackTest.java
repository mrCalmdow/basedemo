package com.flchen.basedemo.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author: flchen
 * Date: 2019/10/14
 * Time: 11:13 AM
 *
 * @Description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayStackTest {
    @Data
    @AllArgsConstructor
    class Item {
        private int id;
        private String name;
    }

    @Test
    public void testArrayStackCurrentlyUse() throws Exception {
        Item lastItem = new Item(6, "last");
        ArrayStack<Item> stack = new ArrayStack(6);
        stack.push(new Item(1, "a"));
        stack.push(new Item(2, "b"));
        stack.push(new Item(2, "b"));
        stack.push(new Item(2, "b"));
        stack.push(new Item(2, "b"));
        stack.push(lastItem);
        List<Item> items = stack.toList();
        for (Item item : items) {
            log.info("Item -> {}", item.toString());
        }
        Item pop = stack.pop();
        log.info("pop -> {}", pop);
        Assert.assertEquals(lastItem, pop);
    }
}
