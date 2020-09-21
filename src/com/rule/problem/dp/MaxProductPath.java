package com.rule.problem.dp;

/**
 * @description: 1594. 矩阵的最大非负积
 * @author: rule
 * @date: 2020-09-21 19:22
 **/
public class MaxProductPath {

    public int maxProductPath(int[][] grid) {
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
                maxDp[i][j] = Math.max(minDp[i][j - 1] * grid[i][j],
                        Math.max(minDp[i - 1][j] * grid[i][j], Math.max(maxDp[i - 1][j] * grid[i][j], maxDp[i][j - 1] * grid[i][j]))) % 1000000007;
                minDp[i][j] = Math.min(minDp[i][j - 1] * grid[i][j],
                        Math.min(minDp[i - 1][j] * grid[i][j], Math.min(maxDp[i - 1][j] * grid[i][j], maxDp[i][j - 1] * grid[i][j]))) % 1000000007;
            }
        }
        if (maxDp[row - 1][col - 1] < 0) {
            return -1;
        }
        return (int) (maxDp[row - 1][col - 1] % 1000000007);
    }
}
