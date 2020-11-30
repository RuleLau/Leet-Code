package com.rule.problem.week;

import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-11-16 09:53
 **/
public class Week215 {

    public static boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Set<Integer> set = new TreeSet<>();
        for (char c : chars1) {
            map1.compute(c, (k, v) -> {
                if (v == null) {
                    return 0;
                }
                return v + 1;
            });
        }
        map1.forEach((k, v) -> set.add(v));
        for (char c : chars2) {
            map2.compute(c, (k, v) -> {
                if (v == null) {
                    return 0;
                }
                return v + 1;
            });
        }
        Collection<Integer> values = map2.values();
        for (Integer value : values) {
            if (!set.contains(value)) {
                return false;
            }
        }
        for (char c : chars1) {
            if (map2.get(c) == null) {
                return false;
            }
        }

        return true;
    }

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        if (x < nums[0] && x < nums[len - 1]) {
            return -1;
        }
        int depth = dfs(nums, x, 0, len, 1);
        if (depth == 0) {
            return -1;
        }
        return depth;
    }

    public int dfs(int[] nums, int x, int left, int right, int depth) {
        if (left >= nums.length || right > nums.length) {
            return 0;
        }
        depth++;
        if (x == 0) {
            return depth;
        }
        int[] rArray = Arrays.copyOfRange(nums, left + 1, right);
        int[] lArray = Arrays.copyOfRange(nums, left, right - 1);
        int a = depth + dfs(rArray, x - nums[0], left + 1, right, depth + 1);
        int b = depth + dfs(lArray, x - nums[right - 1], left, right - 1, depth + 1);
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Week215 week215 = new Week215();
        System.out.println(week215.minOperations(new int[]{3,2,20,1,1,3}, 10));
    }
}
