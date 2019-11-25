package com.rule.problem.dp;

import java.util.Map;

/**
 * @author liurui-1
 * @version 1.0.0
 * @description 数字塔从上到下所有路径中和最大的路径
 * @date 11/25/2019 12:50 PM
 */
public class NumberTowner {

//    数字塔是第i行有i个数字组成，从上往下每个数字只能走到他正下方数字或者正右方数字，求数字塔从上到下所有路径中和最大的路径，如有下数字塔
//    3
//    1    5
//    8    4    3
//    2    6    7    9
//    6    2    3    5    1

    /**
     * 从上往下
     */
    public static int minNumberInRotateArray(int[][] n) {
        int result = 0;
        int[][] dp = new int[n.length + 1][n.length + 1];
        dp[0][0] = n[0][0];
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + n[i][j];
                } else {
                    dp[i][j] = n[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }

    /**
     * 从下往上
     */
    public static int minNumberInRotateArray1(int[][] n) {
        int[][] temp = new int[n.length][n.length];
        // 给最后一行赋值
        for (int i = 0; i < n[n.length - 1].length; i++) {
            temp[n.length - 1][i] = n[n.length - 1][i];
        }
        //
        for (int i = n.length - 2; i >=0 ; i--) {
            for (int j = 0; j < n[i].length; j++) {
                temp[i][j] = Math.max(temp[i + 1][j], temp[i + 1][j + 1]) + n[i][j];
            }
        }
        return temp[0][0];
    }


    public static void main(String[] args) {
        int[][] n = new int[][]{{3}, {1, 5}, {8, 4, 3}, {2, 6, 7, 9}, {6, 2, 3, 5, 1}};
        //System.out.println(minNumberInRotateArray(n));
        System.out.println(minNumberInRotateArray1(n));
    }

}
