package com.algorithm.array;

/**
 * 岛屿问题，从头开始遍历，如果当前位置是1，那就把它四周为1的都变成2，岛屿数+1
 */
public class IslandDemo {

    public static int getIsland(int[][] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr, i, j);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }


    /**
     * 感染 1四周的数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void infect(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 2;
        infect(arr, i + 1, j);
        infect(arr, i - 1, j);
        infect(arr, i, j + 1);
        infect(arr, i, j + 1);
    }
}
