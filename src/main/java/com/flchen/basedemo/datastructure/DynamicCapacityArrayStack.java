package com.flchen.basedemo.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;


/**
 * author: flchen
 * Date: 2019/10/14
 * Time: 11:40 AM
 *
 * @Description:
 **/
@Slf4j
public class DynamicCapacityArrayStack<T> {

    static int DEFAULT_INIT_CAPACITY = 8;
    Object[] items;
    int size = 0;
    int index = 0;

    public <T> DynamicCapacityArrayStack() {
        items = new Object[DEFAULT_INIT_CAPACITY];
        this.size = DEFAULT_INIT_CAPACITY;
    }

    public <T> DynamicCapacityArrayStack(int size) {
        Assert.isTrue(0 < size, "Initialize size must be greater than 0.");
        items = new Object[size];
        this.size = size;
    }


    public boolean push(T var) {
        if (size > index) {
            items[index++] = var;
            return true;
        }
        //TODO expansion double size

        Object[] exp = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            exp[i] = items[i];
        }
        size = size * 2;
        items = exp;
        items[index++] = var;
        return true;
    }

    public T pop() {

        if(0 > index) {
//            throw new Exception("Stack has empty.");
            return null;
        }

        return (T) items[--index];
    }
}
