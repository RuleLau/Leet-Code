package com.rule.problem.week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week255 {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (min >= num) {
                min = num;
            }

            if (max <= num) {
                max = num;
            }
        }
        int k = 0;
        do {
            k = max % min;// 得到余数
            max = min;// 根据辗转相除法,把被除数赋给除数
            min = k;// 余数赋给被除数
        } while (k != 0);
        return max;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Set<String> set = new HashSet<>(Arrays.asList(nums));
        String ans = "";
        int i = 1;

        for (int j = n; j > 0; j--) {
            i = i * 2; //对应位权
        }
        for (i = i - 1; i >= 0; i--) {
            StringBuilder bin = new StringBuilder(Integer.toBinaryString(i));

            while (bin.length() < n) {
                bin.insert(0, "0");
            }
            String s = bin.toString();
            if (!set.contains(s)) {

                ans = s;
                break;
            }
        }
        return ans;
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < col; i++) {
            dp[0][i] = Math.abs(target - mat[0][i]);
        }


        return 0;
    }
}
