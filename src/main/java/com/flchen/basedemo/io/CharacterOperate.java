package com.flchen.basedemo.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * author: flchen
 * Date: 2019-10-12
 * Time: 09:03
 *
 * @Description: 字符操作
 **/
@Slf4j
public class CharacterOperate {

    FileReader fr;
    FileWriter fw;

    /**
     * 字符操作 -- 单个整形读取
     * @param source
     * @param dest
     * @throws IOException
     */
    public void copyFileWithChar(File source, File dest) throws IOException {
        fr = new FileReader(source);
        fw = new FileWriter(dest);

        int i;
        Long startTime =  System.currentTimeMillis();
        log.info("[start time] -- {}", startTime);
        while((i = fr.read()) != -1) {
            fw.write(i);
        }
        fw.flush();
        Long endTime =  System.currentTimeMillis();
        log.info("[end time] -- {}, [spend time] -- {}", endTime, endTime - startTime);
        fr.close();
        fw.close();
    }

    /**
     * 使用字符数组进行文件COPY
     * @param source
     * @param dest
     * @throws IOException
     */
    public void copyFileWithCharArray(File source, File dest) throws IOException {
        fr = new FileReader(source);
        fw = new FileWriter(dest);

        final int BUFFER_SIZE = 16;
        char[] charBuff = new char[BUFFER_SIZE];

        int len;
        Long startTime =  System.currentTimeMillis();
        log.info("[start time] -- {}", startTime);
        while ((len = fr.read(charBuff)) != -1) {
            fw.write(charBuff, 0, len);
        }
        fw.flush();
        Long endTime =  System.currentTimeMillis();
        log.info("[end time] -- {}, [spend time] -- {}", endTime, endTime - startTime);
        fr.close();
        fw.close();
    }
}
