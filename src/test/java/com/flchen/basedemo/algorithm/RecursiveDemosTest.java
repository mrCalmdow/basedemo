package com.flchen.basedemo.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author fl.chen
 * Date 2019-10-25
 * Time 10:20
 * Desc:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecursiveDemosTest {

    @Test
    public void testFibonacciNumberIsRight() {

        RecursiveDemos rf = new RecursiveDemos();

        Assert.assertEquals(1, rf.reduceFibonacci(1));
        Assert.assertEquals(1, rf.reduceFibonacci(2));
        Assert.assertEquals(2, rf.reduceFibonacci(3));
        Assert.assertEquals(3, rf.reduceFibonacci(4));
        Assert.assertEquals(5, rf.reduceFibonacci(5));
        Assert.assertEquals(8, rf.reduceFibonacci(6));
    }


    @Test
    public void testStepWalk() {
        RecursiveDemos rf = new RecursiveDemos();

        Assert.assertEquals(1, rf.reduceStepWalk(1));
        Assert.assertEquals(2, rf.reduceStepWalk(2));
        Assert.assertEquals(3, rf.reduceStepWalk(3));
        Assert.assertEquals(5, rf.reduceStepWalk(4));
        log.info("rf.reduceStepWalk(5) = {}", rf.reduceStepWalk(5));
        log.info("rf.reduceStepWalk(4) = {}", rf.reduceStepWalk(4));
        log.info("rf.reduceStepWalk(20) = {}", rf.reduceStepWalk(20));
    }


    @Test
    public void testNotRecursiveStepWalk() {

        RecursiveDemos rd = new RecursiveDemos();

        Assert.assertEquals(1, rd.reduceStepWalkByNotRecursive(1));
        Assert.assertEquals(2, rd.reduceStepWalkByNotRecursive(2));
        Assert.assertEquals(3, rd.reduceStepWalkByNotRecursive(3));
        Assert.assertEquals(5, rd.reduceStepWalkByNotRecursive(4));
        Assert.assertEquals(8, rd.reduceStepWalkByNotRecursive(5));
        Assert.assertEquals(10946, rd.reduceStepWalkByNotRecursive(20));
    }
}
