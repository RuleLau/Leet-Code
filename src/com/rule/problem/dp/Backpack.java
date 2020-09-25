package com.rule.problem.dp;

/**
 * @description:
 * @author: rule
 * @date: 2020-09-24 16:49
 **/
public class Backpack {

    /**
     * 01 背包
     */
    public static int zeroOneBackpack() {
        //w[]：物品重量，v[]：物品价值，m：背包承重，n：物品个数，maxValue[][]：状态
        //第一个数为0，是为了让输出时，i表示有i个物品
        int[] weight = {10, 3, 4, 5};
        int[] value = {3, 4, 6, 7};
        // 背包容量
        int max = 10;
        int m = weight.length;
        int[][] dp = new int[m][max + 1];
        // 初始化值
        for (int i = 0; i < max + 1; i++) {
            dp[0][i] = weight[0] <= i ? value[0] : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < max + 1; j++) {
                dp[i][j] = j >= weight[i] ? Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]) : dp[i - 1][j];
            }
        }
        return dp[m - 1][max];
    }

    public static void main(String[] args) {
        System.out.println(zeroOneBackpack());
    }

}
