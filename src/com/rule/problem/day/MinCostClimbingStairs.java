package com.rule.problem.day;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == n ? 0 : cost[i]);
        }
        return dp[n];
    }

}
