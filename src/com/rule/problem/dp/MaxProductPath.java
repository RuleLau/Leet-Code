package com.rule.problem.dp;

/**
 * @description: 1594. 矩阵的最大非负积
 * @author: rule
 * @date: 2020-09-21 19:22
 **/
public class MaxProductPath {

    public static int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long[][] maxDp = new long[row][col];
        long[][] minDp = new long[row][col];
        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];
        // 初始值
        for (int i = 1; i < col; i++) {
            maxDp[0][i] = grid[0][i] * maxDp[0][i - 1];
            minDp[0][i] = grid[0][i] * minDp[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            maxDp[i][0] = grid[i][0] * maxDp[i - 1][0];
            minDp[i][0] = grid[i][0] * minDp[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] > 0) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j] * grid[i][j], maxDp[i][j - 1] * grid[i][j]);
                    minDp[i][j] = Math.min(minDp[i][j - 1] * grid[i][j], minDp[i - 1][j] * grid[i][j]);
                } else if (grid[i][j] < 0) {
                    maxDp[i][j] = Math.max(minDp[i - 1][j] * grid[i][j], minDp[i][j - 1] * grid[i][j]);
                    minDp[i][j] = Math.min(maxDp[i][j - 1] * grid[i][j], maxDp[i - 1][j] * grid[i][j]);
                }
            }
        }
        long mod = (long) (1e9 + 7);
        return (int) (maxDp[row - 1][col - 1] < 0 ? -1 : maxDp[row - 1][col - 1] % mod);
    }

    public static void main(String[] args) {
        System.out.println(maxProductPath(new int[][]{
                {1, 4, 4, 0},
                {-2, 0, 0, 1},
                {1, -1, 1, 1}
        }));
    }
}
