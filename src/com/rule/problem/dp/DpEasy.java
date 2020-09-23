package com.rule.problem.dp;

/**
 * @description:
 * @author: rule
 * @date: 2020-09-23 09:26
 **/
public class DpEasy {

    /*按摩师*/
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    /**
     * 面试题 16.17. 连续数列
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 面试题 08.01. 三步问题
     */
    public int waysToStep(int n) {
        // 1 2 4 7 13
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod);
        }
        return (int) (dp[n] % mod);
    }

    /**
     * 392. 判断子序列
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        while (i < n && j < m) {
            if (chars[i] == chars1[j]) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(nums[j] - nums[i], max);
            }
        }
        return max;
    }

}
