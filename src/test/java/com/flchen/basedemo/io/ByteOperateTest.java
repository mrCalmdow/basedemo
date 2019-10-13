package com.flchen.basedemo.io;

import com.flchen.basedemo.io.ByteOperate;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * author: flchen
 * Date: 2019-10-11
 * Time: 22:49
 *
 * @Description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ByteOperateTest {

    File source, destination;
    final String content = "Hello, world! /** * 通过ClassLoader获取的路径为target下面\n" +
            "classes目录中的文件资源，非src目录下的源文件*/";

    @Before
    public void setup() throws IOException {
        /**
         * 通过ClassLoader获取的路径为target下面classes目录中的文件资源，非src目录下的源文件
         */
        String rootPath = System.getProperty("user.dir");
        String sourceFilePath = rootPath.concat("/src/main/resources/xanadu.txt");
        String destinationFilePath = rootPath.concat("/src/main/resources/dest.txt");
        source = new File(sourceFilePath);
        destination = new File(destinationFilePath);
        Writer writer = new FileWriter(source);
        writer.write(content);
        writer.flush();
        writer.close();
    }

    @After
    public void teardown() {
        source.deleteOnExit();
        destination.deleteOnExit();
    }

    @Test
    public void copyFileShouldBeSucceed() throws FileNotFoundException, IOException {
        ByteOperate bo = new ByteOperate();
        bo.copyFileWithByte(source, destination);
        BufferedReader br = new BufferedReader(new FileReader(destination));
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while(StringUtils.hasText(temp = br.readLine())) {
            sb.append(temp).append("\n");
        }
        /**
         * \n为一个字符
         */
        String result = sb.substring(0, sb.length() - 1);
        log.info("result = {}", result);
        log.info("content = {}", content);
        Assert.isTrue(content.equals(result));
        br.close();
    }

    @Test
    public void copyFileWithByteArrayShouldBeSuccess() throws IOException {
        ByteOperate bo = new ByteOperate();
        bo.copyFileWithBufferedByte(source, destination);
        BufferedReader br = new BufferedReader(new FileReader(destination));
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while(StringUtils.hasText(temp = br.readLine())) {
            sb.append(temp).append("\n");
        }
        /**
         * \n为一个字符
         */
        String result = sb.substring(0, sb.length() - 1);
        log.info("result = {}", result);
        log.info("content = {}", content);
        Assert.isTrue(content.equals(result));
        br.close();
    }
}
