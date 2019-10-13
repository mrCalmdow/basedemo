package com.flchen.basedemo.io;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;

/**
 * author: flchen
 * Date: 2019-10-11
 * Time: 22:41
 *
 * @Description: Java文件操作：定位文件，读取、写入文件
 **/
@Slf4j
public class FileOperate {
    /**
     * classLoader获取Resource -- 从classes目录下找； 基于classes目录
     * @return
     */
    public static String getBasePath() {
        ClassLoader classLoader = FileOperate.class.getClassLoader();
        URL resource = classLoader.getResource("outagain.txt");
        return null == resource ? "null" : resource.getPath();
    }

    /**
     * System.property("user.dir") -- 指向当前项目的根目录
     * @return
     */
    public static String getUserDir() {
        String property = System.getProperty("user.dir");
        return property;
    }

    /**
     * 其他一些获取项目路径方式
     */
    public static void testElse() {
        /**
         * 获取包名加类名
         */
        log.info("Class.getCanonicalName = {}", FileOperate.class.getCanonicalName());
        /**
         * 获取类名
         */
        log.info("Class.getSimpleName = {}", FileOperate.class.getSimpleName());
        /**
         * 获取当前类的绝对路径，到父级目录为止（class文件位置，正常是在项目编译后的目录）
         */
        log.info("Class.getResource(\"\") = {}", FileOperate.class.getResource(""));
        /**
         * 获取当前classes目录的绝对路径
         */
        log.info("Class.getResource(\"/\") = {}", FileOperate.class.getResource("/"));
        log.info("Class.getClassLoader.getResource(\"/\") = {}", FileOperate.class.getClassLoader().getResource("/"));
    }

    public static void main(String[] args) {
        FileOperate fi = new FileOperate();
        log.info(fi.getBasePath());
        log.info(fi.getUserDir());
        FileOperate.testElse();
    }
}
