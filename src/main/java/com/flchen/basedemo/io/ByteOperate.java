package com.flchen.basedemo.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * author: flchen
 * Date: 2019-10-11
 * Time: 22:41
 *
 * @Description: Java IO的字节操作
 **/
@Slf4j
public class ByteOperate {

    /**
     * copy file with byte one by one
     * @param source
     * @param destination
     */
    public void copyFileWithByte(File source, File destination) throws IOException {

        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(destination);

            int c;
            Long startTime =  System.currentTimeMillis();
            log.info("[start time] -- {}", startTime);
            while ((c = is.read()) != -1) {
                os.write(c);
            }
            Long endTime =  System.currentTimeMillis();
            log.info("[end time] -- {}, [spend time] -- {}", endTime, endTime - startTime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }

    /**
     * copy file with byte array
     * @param source
     * @param destination
     * @throws IOException
     */
    public void copyFileWithBufferedByte(File source, File destination) throws IOException {

        final int BUFF_SIZE = 1024;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        bis = new BufferedInputStream(new FileInputStream(source));
        bos = new BufferedOutputStream(new FileOutputStream(destination));

        byte[] buff = new byte[BUFF_SIZE];

        int len = 0;
        int offset = len;
        Long startTime =  System.currentTimeMillis();
        log.info("[start time] -- {}", startTime);
        if ((len = bis.read(buff, offset, BUFF_SIZE)) != -1) {
            bos.write(buff, offset, len);
            offset = offset + len;
            log.info("offset = {}, len = {}", offset, len);
        }
        Long endTime =  System.currentTimeMillis();
        log.info("[end time] -- {}, [spend time] -- {}", endTime, endTime - startTime);
        bos.flush();
        bis.close();
        bos.close();
    }
}
