package com.rule.problem.tree.easy;

public class NumTrees {

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees(i - 1) * numTrees(n - i);
        }
        return ans;
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1 ; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
