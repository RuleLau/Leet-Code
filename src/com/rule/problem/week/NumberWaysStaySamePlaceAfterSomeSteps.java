package com.rule.problem.week;

/**
 * week 164
 *
 * @description: 1269. Number of Ways to Stay in the Same Place After Some Steps
 * @author: rule
 * @date: 2019-11-24 18:13
 **/
public class NumberWaysStaySamePlaceAfterSomeSteps {
    static int mod = (int) Math.pow(10, 9) + 7;

    /**
     * time limit seed
     */
    public static int numWays(int steps, int arrLen) {
        return move(steps, arrLen, 0, 0);
    }

    public static int move(int steps, int arrLen, int index, int flag) {
        if (index < 0 || index == arrLen || steps < 0) {
            return 0;
        }

        if (steps == 0 && index == 0 && flag == 1) {
            return 1;
        }
        // stay
        int c1 = move(steps - 1, arrLen, index, 1) % mod;
        // right
        int c2 = move(steps - 1, arrLen, index + 1, 1) % mod;
        // left
        int c3 = move(steps - 1, arrLen, index - 1, 1) % mod;
        return c1 + c2 + c3;
    }

    public static int numWays1(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps + 1);
        int[][] dp = new int[steps + 1][arrLen];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j < arrLen; ++j) {
              // stay
              dp[i][j] = dp[i - 1][j];
              //left
              if (j + 1 < arrLen) {
                  dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
              }
              // right
              if (j > 0) {
                  dp[i][j] = (dp[i][j] + dp[i - 1][j - 1])  % mod;
              }
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        //System.out.println(numWays(3, 2));
        System.out.println(numWays(15, 10));
        System.out.println(numWays1(15, 10));
    }
}
