package com.flchen.basedemo.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: flchen
 * Date: 2019/10/14
 * Time: 10:07 AM
 *
 * @Description: 使用固定数组实现栈，最基本实现
 **/
public class ArrayStack<T> implements Iterable<T> {

    private static int INIT_CAPACITY = 4;
    Object [] elements;
    int count = 0;
    int index = 0;

    public ArrayStack() {
        this(INIT_CAPACITY);
    }

    public ArrayStack(int n) {
        this.INIT_CAPACITY = n;
        elements = new Object[INIT_CAPACITY];
    }

    public void push(T item) throws Exception {
        if (count >= INIT_CAPACITY || index >= INIT_CAPACITY) {
            /**
             * 栈满：1、抛出异常
             */
            throw new Exception("stack overflow~~");
        }
        elements[index] = item;
        index++;
        count++;
    }

    public T pop() throws Exception {
        if(0 >= index || 0 >= count) {
            throw new Exception("stack is empty.");
        }
        Object element = elements[index - 1];
        index--;
        count--;
        return (T) element;
    }

    /**
     * 转换成ArrayList，由栈底到栈顶的顺序
     * @return
     */
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            list.add((T) elements[i]);
        }
        return list;
    }

    /**
     * TODO 实现迭代器功能
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
