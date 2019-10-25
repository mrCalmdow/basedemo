package com.flchen.basedemo.datastructure;

import org.springframework.util.Assert;

/**
 * author fl.chen
 * Date 2019-10-24
 * Time 21:34
 * Desc:
 **/
public class CircledArrayQueue<T> {

    private Object[] items;
    private int INIT_SIZE = 8;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public CircledArrayQueue() {
        this.items = new Object[INIT_SIZE];
        this.size = INIT_SIZE;
    }

    public CircledArrayQueue(int capacity) {
        Assert.isTrue(0 < capacity, "queue's capacity must be greater than 0.");
        this.items = new Object[capacity];
        this.size = capacity;
    }

    /**
     * 关键是判断队满，与入队后队尾指针的递增
     * @param var
     * @return
     */
    public boolean enqueue(T var) {
        if ((tail + 1) % size == head) {
            return false;
        }
        items[tail] = var;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 队空条件与队头指针递增
     * @return
     */
    public T dequeue() {

        if(tail == head) return null;
        T var = (T) items[head];
        head = (head + 1) % size;
        return var;
    }
}
