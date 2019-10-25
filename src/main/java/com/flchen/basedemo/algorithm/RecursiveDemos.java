package com.flchen.basedemo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * author fl.chen
 * Date 2019-10-25
 * Time 10:14
 * Desc:
 * 1 Fibonacci数列：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * 2 走台阶：N级台阶，每一步可以走1阶或2阶； 计算走完N级台阶有多少种走法。
 **/
public class RecursiveDemos {

    Map<Integer, Integer> stepCache = new HashMap<>();

    public int reduceFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return reduceFibonacci(n - 1) + reduceFibonacci(n - 2);
    }

    public int reduceStepWalk(int stepCount) {

        if (stepCount == 1) {
            return 1;
        }
        if (stepCount == 2) {
            return 2;
        }
        if (stepCache.containsKey(stepCount)) {
            return stepCache.get(stepCount);
        }
        int rs = reduceStepWalk(stepCount - 1) + reduceStepWalk(stepCount - 2);
        stepCache.put(stepCount, rs);
        return rs;
    }

    public int reduceStepWalkByNotRecursive(int step) {

        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        int pre = 2;
        int prePre = 1;
        int rs = 0;
        for (int i = 3; i <= step; i++) {
            rs = pre + prePre;
            prePre = pre;
            pre = rs;
        }
        return rs;
    }
}
