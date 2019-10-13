package com.flchen.basedemo.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * author: flchen
 * Date: 2019-10-12
 * Time: 15:30
 *
 * @Description:
 **/
@Slf4j
public class SerializableOperate implements Serializable {

    @Data
    @AllArgsConstructor
    public class A implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int capacity;

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }

    @Data
    @AllArgsConstructor
    public static class B {
        private String name;
        private int capacity;

        @Override
        public String toString() {
            return "B{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }
}
