package com.rule.problem.week;

public class WeekDouble34 {

    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0;
        int right = n - 1;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == left || j == right) {
                    sum += mat[i][j];
                }
            }
            left++;
            right--;
        }
        return sum;
    }

    //   10101
    //   01234
    //dp 112|2|3
    public int numWays(String s) {
        int ans = 0;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = s.charAt(0) == '1' ? 1 : 0;
        // 1 存放的位置
        for (int i = 1; i < len; i++) {
            dp[i] = s.charAt(i) == '1' ? dp[i - 1] + 1 : dp[i - 1];
        }
        int first = len - 2;
        int second = len - 1;
        while (second != 1) {
            if (first == 0) {
                second--;
                first = second - 1;
            }
            if (first != 0 && splitThree(first, second, dp, len)) {
                ans++;
            }
            first--;
        }
        return ans % (100000000 + 7);
    }

    public boolean splitThree(int first, int second, int[] dp, int len) {
        int b = dp[second - 1] - dp[first - 1];
        int c = dp[len - 1] - dp[second - 1];
        return dp[first - 1] == b && b == c;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int first = 0;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                first = i + 1;
                break;
            }
        }
        int left = first - 1;
        int right = first + 1;
        while (left == 0 || right == len - 1) {
            if (arr[left] > arr[right]) {
                right++;
            }else {
                
            }

        }

        return 0;
    }


    public static void main(String[] args) {
        WeekDouble34 w = new WeekDouble34();
        /*System.out.println(w.diagonalSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));*/
        System.out.println(w.numWays("100100010100110"));

    }
}
