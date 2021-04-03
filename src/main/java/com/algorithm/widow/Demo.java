package com.algorithm.widow;

import java.util.LinkedList;

/**
 * 求解一个数据组，子数组的最大值-子数组的最小值小于等于num的组数有多少
 */
public class Demo {
    public int getResult(int[] arr, int num) {
        if (arr.length < 1) {
            return 0;
        }
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length) {
            while (R < arr.length) {
                //不断弹出比当前值小的数
                while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[R]) {
                    maxList.pollLast();
                }
                maxList.addLast(R);
                //不断弹出比当前值大的数
                while (!minList.isEmpty() && arr[minList.peekLast()] >= arr[R]) {
                    minList.pollLast();
                }
                minList.addLast(R);
                //如果当前最大值与最小值大于给定值，终止循环
                if (arr[maxList.peekFirst()] - arr[minList.peekFirst()] > num) {
                    break;
                }
                //否则继续向右扩
                R++;
            }

            //如果第一个值过期，弹出
            if (maxList.peekFirst() == L) {
                maxList.pollFirst();
            }
            //如果第一个值过期，弹出
            if (minList.peekFirst() == L) {
                minList.pollFirst();
            }
            //以下标L开头的满足条件的个数
            res += R - L;
            //向右扩充一位
            L++;
        }
        return res;
    }
}
