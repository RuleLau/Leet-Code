package com.rule.problem.week;

import java.util.Arrays;

/**
 * @description:
 * @author: rule
 * @date: 2019-11-17 17:54
 **/
public class GreatestSumDivisibleThree {
    public static int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        int[] g = new int[3];
        dp[0] = 0;
        dp[1] = dp[2] = -1;
        for (int i = 0; i < nums.length; i++) {
            g[0] = g[1] = g[2] = -1;
            for (int j = 0; j < 3; j++) {
                if (dp[j] == -1) {
                    continue;
                }
                g[(j + nums[i]) % 3] = Math.max(g[(j + nums[i]) % 3], dp[j] + nums[i]);
            }
            for (int j = 0; j < 3; j++) {
                dp[j] = Math.max(dp[j], g[j]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,3,1,8};
        int[] nums1 = new int[]{1,2,3,4,4};
        System.out.println(maxSumDivThree(nums));
        System.out.println(maxSumDivThree(nums1));
    }

}
