package com.rule.problem.day;


public class MaxProfit {

    // [1, 3, 2, 8, 4, 9],   2
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 持有股票所剩的最多现金
        dp[0][0] = -prices[0];
        // 持有的最多现金
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public int maxProfitII(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 不持有
        dp[0][0] = 0;
        // 持有
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int maxProfitIII(int[] prices) {
        int n = prices.length;
        int res = 0;
        int min1 = Integer.MAX_VALUE, max1 = 0;
        for(int i = 0; i < n; ++i){//将区间分为左右两段
            //求左区间[0,i]买入卖出最大差值
            min1 = Math.min(min1, prices[i]);
            max1 = Math.max(max1, prices[i] - min1);
            //求右区间[i,n-1]买入卖出最大差值
            int min2 = Integer.MAX_VALUE, max2 = 0;
            for(int j = i; j < n; ++j){
                min2 = Math.min(min2, prices[j]);
                max2 = Math.max(max2, prices[j] - min2);
            }
            res = Math.max(res, max1+max2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfitIII(new int[]{1,2,3,4,5}));
    }

}
