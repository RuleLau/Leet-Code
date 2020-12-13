package com.rule.problem.week;

public class Week219 {

    public int numberOfMatches(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                ans += n;
            } else {
                n = n - 1;
                ans += n / 2;
                n = n / 2 + 1;
            }
        }
        return ans;
    }

    public int minPartitions(String n) {
        int ans = 0;
        char[] chars = n.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = Character.getNumericValue(chars[i]);
            ans = Math.max(num, ans);
        }
        return ans;
    }

    public int stoneGameVII(int[] stones) {
        int sum = 0;
        int len = stones.length;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int[] dp = new int[len];
        dp[0] = sum - Math.min(stones[0], stones[len - 1]);
        for (int i = 1; i < len; i++) {
            dp[0] = sum - Math.min(stones[i], stones[len - i - 1]);
        }
        return sum;
    }
}
