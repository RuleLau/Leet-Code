package com.rule.problem.dp;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1 && i != m - 1) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else if (i == m - 1 && j < n - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                }else if (i == m - 1 && j == n - 1){
                    continue;
                }else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }

}
