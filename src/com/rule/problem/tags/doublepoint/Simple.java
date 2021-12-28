package com.rule.problem.tags.doublepoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Simple {

    /**
     * 88. 合并两个有序数组
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 3,4,5 6, || 1,2,3
        int a = m - 1;
        int b = n - 1;
        int k = m + n - 1;
        while (a >= 0 || b >= 0) {
            if (a == -1) {
                nums1[k--] = nums2[b--];
            } else if (b == -1) {
                nums1[k--] = nums1[a--];
            } else if (nums1[a] >= nums2[b]) {
                nums1[k--] = nums1[a--];
            } else if (nums1[a] < nums2[b]) {
                nums1[k--] = nums2[b--];
            }
        }
    }

    /**
     * 345. 反转字符串中的元音字母
     */
    public String reverseVowels(String s) {
        Set<Character> sets = new HashSet<>();
        sets.add('A');
        sets.add('E');
        sets.add('I');
        sets.add('O');
        sets.add('U');
        sets.add('a');
        sets.add('e');
        sets.add('i');
        sets.add('o');
        sets.add('u');
        char[] chars = s.toCharArray();
        int a = 0;
        int b = chars.length - 1;
        while (a < b) {
            if (sets.contains(chars[a])) {
                if (sets.contains(chars[b])) {
                    char c = chars[a];
                    chars[a] = chars[b];
                    chars[b] = c;
                    a++;
                }
                b--;
            } else {
                a++;
            }
        }
        return String.valueOf(chars);
    }

    /**
     * 485. 最大连续 1 的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        //[1,1,0,1,1,1]
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
            } else {
                max = Math.max(k, max);
                k = 0;
            }
        }
        return Math.max(k, max);
    }

    /**
     * 594. 最长和谐子序列
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) i++;
            if (nums[j] - nums[i] == 1) ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

    }

}
