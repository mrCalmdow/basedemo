package com.flchen.basedemo.algorithm;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * author: flchen
 * Date: 2019/10/13
 * Time: 11:05 AM
 *
 * @Description: 利用单身链表实现LRU（Least Recently Used）算法：
 * 固定边界缓存空间，当有新缓存进入时插入到最前部，同时淘汰最末尾元素；
 * 当缓存元素被命中时，移动到首部
 **/
@Slf4j
public class LRUWithSingleLinked<T> {

    private int maxCacheSize = 8;
    @Getter
    private int len;

    private Node<T> header;
    private Node<T> tail;

    public LRUWithSingleLinked() {
        len = 0;
    }

    public LRUWithSingleLinked(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    /**
     *
     * @param value
     * @return
     */
    public Node<T> add(T value) {
        /**
         * 如果是第一个元素
         */
        if (null == header) {
            Node<T> tNode = new Node<>();
            tNode.setValue(value);
            tNode.setPre(null);
            tNode.setNext(null);
            header = tNode;
            tail = header;
            len = 1;
            log.info("[Fist Node] --- value =  {}", value.toString());
            return header;
        }

        Node<T> node = this.getNode(value);

        /**
         * 如果命中缓存中元素，将其放到第一个位置
         */
        if (null != node) {
            /**
             * 如果命中第一个则直接返回
             */
            if (header.equals(node)) {
                return header;
            }
            /**
             * 如果命令最后一个元素
             */
            if(null == node.getNext() || node.equals(getTail())) {
                // 自断
                node.getPre().setNext(null);
            } else {
                // 命中中间的
                /**
                 * 双向链表，删除某个节点时，前后两个节点都要操作
                 */
                Node<T> next = node.getNext();
                Node<T> pre = node.getPre();
                // 后面元素的前继 --> 被删元素的前继
                next.setPre(pre);
                // 前面元素的后继  --> 被删元素的后继
                pre.setNext(next);
            }

            /**
             * 新增一个节点，不能再用原来node的引用;
             * 替换头节点时，一定要注意，先把旧头指向新元素。
             */
            Node<T> tNode = new Node<>();
            header.setPre(tNode);// 替换头节点时，一定记得 --> 先把旧头，指向新元素
            tNode.setValue(node.getValue());
            tNode.setPre(null);
            tNode.setNext(header);
            header = tNode;
            log.info("[Hit cache Node] --- value =  {}", value.toString());
            return header;
        }

        /**
         * 未命中缓存； 如果空间满，删除最后一个，把当前节点插入到第一个
         */
        if(maxCacheSize == len && node == null) {
            tail = getTail();
            tail = tail.getPre();
            tail.setNext(null);

            Node<T> tNode = new Node<T>();
            header.setPre(tNode);
            tNode.setValue(value);
            tNode.setNext(header);
            tNode.setPre(null);
            header = tNode;
            log.info("[Not Hit cache Node full] --- value =  {}", value.toString());
            return header;
        }

        /**
         * 未命中； 空间未满
         */
        Node<T> tNode = new Node<>();
        header.setPre(tNode);
        tNode.setValue(value);
        tNode.setNext(header);
        tNode.setPre(null);
        header = tNode;
        len++;
        log.info("[Hit cache Node not full] --- value =  {}", value.toString());
        return header;
    }

    /**
     * 判断元素是否在缓存中
     * @param value
     * @return
     */
    public boolean isCached(T value) {
        if(null == header) {
            return false;
        }
        Node<T> next = header.next;
        while(null != next) {
            if (value.equals(next.value)) {
                log.info("[Hit cache] --- value =  {}", value.toString());
                return true;
            }
            next = next.next;
        }
        return false;
    }

    /**
     * 根据元素内容取到Node，如不存在返回Null
     * @param value
     * @return
     */
    public Node<T> getNode(T value) {
        long startTime = System.currentTimeMillis();
        if (null == value) {
            return null;
        }
        Node<T> next = header;
        while(null != next) {
            if (value.equals(next.value)) {
                long endTime = System.currentTimeMillis();
                log.info("[getNode spend time] -- spend -{}", endTime - startTime);
                return next;
            }
            next = next.next;
        }
        return null;
    }

    /**
     * 获取尾节点
     * @return
     */
    public Node<T> getTail() {
        Node<T> next = header.next;
        while (null != next) {
            tail = next;
            next = next.next;
        }
        return tail;
    }

    public Node<T> getHeader() {
        return this.header;
    }

    /**
     * 将内容转换成JDK自带的LinkedList返回
     * @return
     */
    public List<T> values() {
        long startTime = System.currentTimeMillis();
        List<T> result = new LinkedList<>();
        if (null == header) {
            return result;
        }
        result.add(header.getValue());
        Node<T> next = header.next;
        while(null != next) {
            result.add(next.getValue());
            next = next.next;
        }
        long endTime = System.currentTimeMillis();
        log.info("[values spend time] -- spend -{}", endTime - startTime);
        return result;
    }

    @Data
    class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> pre;
    }
}
