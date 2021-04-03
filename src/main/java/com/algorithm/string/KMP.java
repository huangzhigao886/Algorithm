package com.algorithm.string;

public class KMP {
    public int getIndex(String str1, String str2) {
        if (str1.length() < 1 || str2.length() < 1 || str1.length() < str2.length()) {
            return -1;
        }

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(str2Arr);
        while (i1 < str1Arr.length && i2 < str1Arr.length) {
            //如果两个字符相等，两者同时向右移动一位
            if (str1Arr[i1] == str2Arr[i2]) {
                i1++;
                i2++;
            } else {
                //如果不相等，且next[i2] == -1代表i2在str2的开头位置，str1向后移动一位继续与str2从头比较
                if (next[i2] == -1) {
                    i1++;
                } else {
                    //否则将i2跳到str2的最长前缀的位置，与i1的当前位置继续进行比较
                    i2 = next[i2];
                }
            }
        }

        //如果i2到达str2的终点，证明找到index位置
        return i2 == str2Arr.length ? i1 - i2 : -1;
    }


    public int[] getNext(char[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (arr[i - 1] == arr[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
