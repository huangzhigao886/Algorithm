package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/11
 * @Description:
 */
public class Leecode200 {
    public int numIslands(char[][] grid) {
        int column = grid[0].length;
        int row = grid.length;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    color(grid, i, j, row, column);
                }
            }
        }
        return res;
    }

    public void color(char[][] grid, int l, int r, int row, int column) {
        if (l < 0 || r < 0 || l >= row || r >= column || grid[l][r] != '1') {
            return;
        }
        grid[l][r] = '2';
        color(grid, l - 1, r, row, column);
        color(grid, l + 1, r, row, column);
        color(grid, l, r + 1, row, column);
        color(grid, l, r - 1, row, column);
    }
}
