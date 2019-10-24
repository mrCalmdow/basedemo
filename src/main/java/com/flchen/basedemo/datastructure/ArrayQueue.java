package com.flchen.basedemo.datastructure;

/**
 * author fl.chen
 * Date 2019-10-24
 * Time 16:18
 * Desc: 数组实现的顺序队列
 **/
public class ArrayQueue<T> {
    private int INIT_SIZE = 8;
    private Object[] items;
    private int head = 0;
    private int tail = 0;
    private int size = 0;  // 队列大小

    public ArrayQueue() {
        this.items = new Object[INIT_SIZE];
        this.size = INIT_SIZE;
    }

    public ArrayQueue(int capacity) {
        this.items = new Object[capacity];
        this.size = capacity;
    }

    /**
     * 入队
     * @param obj
     * @return
     */
    public boolean enqueue(T obj) {
        if (tail == size) {
            if (head > 0) {
                // 队列尾指针到数据最后，头指针却不在数据首部时； 说明数组未完全被使用
                resize();
            } else {
                // 队列已满
                return false;
            }
        }
        items[tail] = obj;
        tail++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        return (T) items[head++];
    }

    /**
     * 当队列资源用完时（队列内再无有效数据时），重新设置队头和队尾
     * 需要重新处理队列的场景：队列tail已经到数组尾部，队列head不在数组开始位置
     */
    private void resize() {
        for(int i = head; i < tail; i++) {
            items[i - head] = items[i]; // 依次往前挪
        }
        // 挪完之后，重置头和尾
        tail = tail - head;
        head = 0;
    }
}
