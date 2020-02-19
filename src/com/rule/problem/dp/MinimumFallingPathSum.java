package com.rule.problem.dp;

/**
 * 931
 */
public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] A) {
        int m = A.length;
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                }
                if (j == m - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                }
                if (j > 0 && j < m - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + A[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {-11, -48, -69, 6, -3}, {12, 51, 77, -1, -38},
                {-7, 62, 75, 63, -63}, {100, 27, -84, 45, 98},
                {-20, 36, -37, -58, 44}};
        minFallingPathSum(A);
    }
}
