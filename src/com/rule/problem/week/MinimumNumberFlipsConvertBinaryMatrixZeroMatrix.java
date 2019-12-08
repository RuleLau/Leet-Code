package com.rule.problem.week;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: week 166 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
 * @author: rule
 * @date: 2019-12-08 21:27
 **/
public class MinimumNumberFlipsConvertBinaryMatrixZeroMatrix {

    public static boolean check(int[][] mat, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int func(int[][] mat, int n, int m, HashSet<String> set, HashMap<String, Integer> dp) {

        if (check(mat, n, m)) {
            return 0;
        }

        String t = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t += Integer.toString(mat[i][j]);
            }
        }

        if (dp.containsKey(t)) {
            return dp.get(t);
        }
        if (set.contains(t)) {
            return Integer.MAX_VALUE;
        }

        set.add(t);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                mat[i][j] = mat[i][j] ^ 1;
                if (i - 1 >= 0) {
                    mat[i - 1][j] = mat[i - 1][j] ^ 1;
                }
                if (i + 1 < n) {
                    mat[i + 1][j] = mat[i + 1][j] ^ 1;
                }
                if (j - 1 >= 0) {
                    mat[i][j - 1] = mat[i][j - 1] ^ 1;
                }
                if (j + 1 < m) {
                    mat[i][j + 1] = mat[i][j + 1] ^ 1;
                }

                int small = func(mat, n, m, set, dp);
                if (small != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + small);
                }

                mat[i][j] = mat[i][j] ^ 1;
                if (i - 1 >= 0) {
                    mat[i - 1][j] = mat[i - 1][j] ^ 1;
                }
                if (i + 1 < n) {
                    mat[i + 1][j] = mat[i + 1][j] ^ 1;
                }
                if (j - 1 >= 0) {
                    mat[i][j - 1] = mat[i][j - 1] ^ 1;
                }
                if (j + 1 < m) {
                    mat[i][j + 1] = mat[i][j + 1] ^ 1;
                }
            }
        }

        set.remove(t);
        dp.put(t, min);
        return min;

    }

    public static int minFlips(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = func(mat, n, m, new HashSet<>(), dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
