package com.flchen.basedemo.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.*;

/**
 * author: flchen
 * Date: 2019-10-12
 * Time: 15:34
 *
 * @Description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SerializableOperateTest {

    @Test
    public void serializeObject() throws IOException, ClassNotFoundException {

        /**
         * 关于内部类：
         * 正常内部类 -- 实例化时，需要先实例化外部类，再使用外部类的实例new对象
         * 静态内部类 -- 可以直接new Out.Inner()的方式实例化； 但内部类与外部类共享资源时，外部资源必须为static
         */
        SerializableOperate so = new SerializableOperate();
        SerializableOperate.A a = so.new A("AAA", 1);

        String filePath = System.getProperty("user.dir").concat("/src/main/resources/xanadu.txt");

        /**
         * 关于Serializable接口的实现：
         * 内部类实现serializable，外部类未实现时，Serialize失败抛出异常
         */
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
        oos.writeObject(a);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
        SerializableOperate.A a1 = (SerializableOperate.A) ois.readObject();
        log.info("[object] -- {}", a1.toString());
        Assert.isTrue(a.toString().equals(a1.toString()));
    }
}
