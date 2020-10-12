package com.rule.problem.dp;

public class DpMedium {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 背包容量为整数，sum + S为奇数的话不满足要求
        if (((sum + S) & 1) == 1) {
            return 0;
        }
        // 目标和不可能大于总和
        if (S > sum) {
            return 0;
        }
        sum = (sum + S) >> 1;
        int len = nums.length;
        int[][] dp = new int[len + 1][sum + 1];
        dp[0][0] = 1;
        // 01背包
        // i(1 ~ len)表示遍历（不一定选）了 i 个元素，j(0 ~ sum) 表示它们的和
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                // 装不下（不选当前元素）
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                    // 可装可不装（当前元素可选可不选）
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        } 
        return dp[len][sum];
    }


    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }
}


