package com.algorithm.dp;

/**
 * 最短路径和
 */
public class ShortestPath {
    public int precess(int[][] arr, int i, int j) {
        if (i == arr.length && j == arr[0].length) {
            return arr[i][j];
        }
        if (i == arr.length) {
            return arr[i][j] + precess(arr, i, j + 1);
        }

        if (j == arr[0].length) {
            return arr[i][j] + precess(arr, i + 1, j);
        }
        int right = precess(arr, i + 1, j);
        int down = precess(arr, i, j + 1);
        return arr[i][j] + Math.min(right, down);
    }
}
