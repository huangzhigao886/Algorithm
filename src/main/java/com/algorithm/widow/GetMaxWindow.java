package com.algorithm.widow;

import java.util.LinkedList;

public class GetMaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            //不断的弹出尾部比当前值小的数
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.addLast(i);
            //如果当前的最大值已经过期，弹出
            if (list.peekFirst() == i - w) {
                list.pollFirst();
            }
            //当可以形成窗口时，收集数据
            if (i >= w - 1) {
                result[index++] = arr[list.peekFirst()];
            }
        }


        return result;
    }
}
