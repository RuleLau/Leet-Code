package com.rule.problem.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * week203
 */
public class Week203 {

    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        if (start == end) {
            ans.add(start);
        } else if (start < end) {
            while (start <= end) {
                ans.add(start++);
            }
        } else {
            while (end >= 1) {
                ans.add(end--);
            }
            while (start <= n) {
                ans.add(start++);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public int maxCoins(int[] piles) {
        // 1 2 2 4 7 8
        // 1 2 3 4 5 6 7 8 9
        Arrays.sort(piles);
        int low = 0;
        int right = piles.length - 2;
        int sum = 0;
        while (low <= right) {
            sum += piles[right];
            low += 1;
            right -= 2;
        }
        return sum;
    }

    public static int findLatestStep(int[] arr, int m) {
        StringBuilder str = new StringBuilder();
        int len = arr.length;
        if (len == m) {
            return len;
        }
        for (int i = 0; i < len; i++) {
            str.append('0');
        }
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            str.setCharAt(arr[i] - 1, '1');
            if (i >= m - 1) {
                res = check(str, m) ? i + 1 : res;
            }
        }
        return res;
    }

    private static boolean check(StringBuilder str, int m) {
        int len = str.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == '0') {
                if (temp.length() == m) {
                    return true;
                }
                temp.setLength(0);
            } else {
                temp.append(c);
                if (i == len - 1 && temp.length() == m) {
                    return true;
                }
            }
        }
        return false;
    }


    public static int findLatestStepI(int[] arr, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(arr.length + 1);
        if (arr.length == m) {
            return arr.length;
        }
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int index = arr[i];
            int a = set.lower(index);
            int b = set.higher(index);
            if (index - a - 1 == m || b - index - 1 == m) {
                return i;
            }
            set.add(index);
        }
        return -1;
    }

    public static void main(String[] args) {
        //mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2});
        findLatestStepI(new int[]{3, 5, 1, 2, 4}, 1);
    }

}
