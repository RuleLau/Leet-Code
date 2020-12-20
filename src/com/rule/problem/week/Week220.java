package com.rule.problem.week;

import java.util.*;

public class Week220 {

    public String reformatNumber(String number) {
        String replace = number.replace(" ", "").replace("-", "");
        char[] chars = replace.toCharArray();
        if (chars.length <= 3) {
            return replace;
        }
        int len = chars.length;
        int remain = len % 3;
        StringBuilder ans = new StringBuilder();
        if (remain == 1) {
            remain = 4;
        }
        for (int i = 0; i < len - remain; i++) {
            if (i % 3 == 0 && i != 0) {
                ans.append("-");
            }
            ans.append(chars[i]);
        }
        if (remain > 0 && ans.length() != 0) {
            ans.append("-");
        }
        if (remain == 2) {
            while (remain > 0) {
                ans.append(chars[len - remain]);
                remain--;
            }
        } else if (remain == 4) {
            while (remain > 0) {
                if (remain == 2) {
                    ans.append("-");
                }
                ans.append(chars[len - remain]);
                remain--;
            }
        }
        return ans.toString();
    }

    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            Integer index = map.get(nums[i]);
            sum += nums[i];
            if (index != null) {
                for (int j = start; j <= index; j++) {
                    sum -= nums[j];
                    map.remove(nums[j]);
                }
                start = index + 1;
            }
            map.put(nums[i], i);
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        dp[0][0] = nums[0];
        for (int i = 1; i <= Math.min(len - 1, i + k); i++) {
            dp[0][i] = nums[0] + nums[i];
        }
        dp[0][0] = nums[0];
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j <= Math.min(i + k, len - 1); j++) {
                dp[i][j] = Math.max(nums[j] + dp[i - 1][j - 1], dp[i][j - 1]);
            }
        }
        return dp[len - 1][len - k];
    }

    public static void main(String[] args) {
        Week220 week220 = new Week220();
        System.out.println(week220.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5, 4}));
    }
}
