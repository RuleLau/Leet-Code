package com.rule.problem.week;

import java.util.HashSet;
import java.util.Set;


public class WeekDouble41 {

    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = allowed.toCharArray();
        Set<Character> all = new HashSet<>();
        for (char aChar : chars) {
            all.add(aChar);
        }
        int ans = 0;
        for (String temp : words) {
            char[] array = temp.toCharArray();
            int j;
            for (j = 0; j < array.length; j++) {
                if (!all.contains(array[j])) {
                    break;
                }
            }
            if (j == array.length) {
                ans++;
            }
        }
        return ans;
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 1; i < len; i++) {
            ans[0] += (nums[i] - nums[0]);
        }
        for (int i = 1; i < len; i++) {
            int n = nums[i] - nums[i - 1];
            ans[i] = ans[i - 1] + (2 * i - len) * n;
        }
        return ans;
    }
    public static void main(String[] args) {
        WeekDouble41 w = new WeekDouble41();
        w.getSumAbsoluteDifferences(new int[]{2,3,5});
    }

}
