package com.flchen.basedemo.datastructure;

import lombok.extern.slf4j.Slf4j;


/**
 * author: flchen
 * Date: 2019/10/14
 * Time: 11:40 AM
 *
 * @Description:
 **/
@Slf4j
public class DynamicCapacityArrayStack<T> {

    int DEFAULT_INIT_CAPACITY = 8;
    Object[] items;
    int size = 0;
    int index = 0;

    public <T> DynamicCapacityArrayStack() {
        items = new Object[DEFAULT_INIT_CAPACITY];
    }

    public <T> DynamicCapacityArrayStack(int size) {
        items = new Object[size];
        this.size = size;
    }


}
