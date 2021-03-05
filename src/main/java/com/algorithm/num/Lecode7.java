package com.algorithm.num;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description:
 */
public class Lecode7 {
    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        int x = 1463847412;
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(reverse(x));
    }
}
