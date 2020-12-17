package com.rule.problem.day;


public class MaxProfit {

    // [1, 3, 2, 8, 4, 9],   2
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 持有股票所剩的最多现金
        dp[0][0] = -prices[0];
        // 持有的最多现金
        dp[0][1] = 0 ;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] =  Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
