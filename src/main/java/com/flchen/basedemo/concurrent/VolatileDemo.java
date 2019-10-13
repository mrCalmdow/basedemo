package com.flchen.basedemo.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * author: flchen
 * Date: 2019-10-09
 * Time: 14:31
 *
 * @Description: volatile最常用的暴露变量，成为线程间共享状态。
 * 遇到的一个问题：
 * 当isOver不用volatile修饰时，run方法中使用了System.out.println();也会使线程停止，
 * 原因是println中有Synchronized同步锁，Synchronized会使用主内存和线程中的变量副本强制刷新一次。
 **/
@Slf4j
public class VolatileDemo implements Runnable{

    public boolean isOver = false;
//    public volatile boolean isOver = false;

    @Override
    public void run() {
        System.out.println("ready to run.");
        while (!isOver) {
            System.out.println("run~");
//            log.info("run~");
        }
    }

    public void changeFlag() {
        isOver = true;
    }

    public static void main(String[] args) {
        VolatileDemo vd = new VolatileDemo();
        Thread t1 = new Thread(vd);
        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vd.changeFlag();
        // 全局变量isOver为true时run方法结束，退出线程；如isOver在run方法中一直读到为false则一直不退出线程。
        System.out.println("Stop Run.");
    }
}
