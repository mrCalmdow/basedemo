package com.flchen.basedemo.collections;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * author: flchen
 * Date: 2019/10/13
 * Time: 10:09 AM
 *
 * @Description: 单一链表
 **/
@Slf4j
@Data
public class SingleLinkedDemo<T> {

    private int size = 0;

    @Data
    class Node<T> {
        private T value;
        private Node next;
    }

    public void iterateLinkedList(Node<T> header) {
        Assert.notNull(header, "Header can't be null");
        if (null == header) {
            return ;
        }
        Node<T> next = header;
        do {
            log.info("next.value = {}", next.value);
        } while (null != (next = next.next));
    }

    public Node<T> createLinkedList(T[] sourceArray) {
//        Assert.notEmpty(sourceArray, "Source array can't be empty.");
        if (CollectionUtils.isEmpty(CollectionUtils.arrayToList(sourceArray))) {
            return null;
        }
        size += 1;
        Node<T> header = new Node<>();
        header.setValue(sourceArray[0]);
        Node<T> floatNode = header;
        int len = sourceArray.length;
        for (int i = 1; i < len; i++) {
            Node<T> node = new Node<>();
            node.setValue(sourceArray[i]);
            floatNode.next = node;
            floatNode = floatNode.next;
            size ++;
        }
        return header;
    }
}
