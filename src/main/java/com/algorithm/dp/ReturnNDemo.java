package com.algorithm.dp;

/**
 * 求N的阶乘
 */
public class ReturnNDemo {
    public long getResult(int N) {
        if (N == 1) {
            return 1;
        }
        return N * getResult(N - 1);
    }
}
