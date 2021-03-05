package com.algorithm.EasyDemo;

import java.util.Arrays;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/2
 * @Description: 简单案列
 */
public class EasyDemo {
    public static boolean Find(int target, int[][] array) {

        int rows = array.length;
        int cols = array[0].length;
        if (rows == 0 || cols == 0) {
            return false;
        }
        int row = rows - 1;
        int col = 0;
        boolean flag = false;
        while (col < cols && row >= 0) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }

        return flag;
    }



    public void reverseString(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;

        }
    }


    public int sort(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(7, arr));
    }
}
