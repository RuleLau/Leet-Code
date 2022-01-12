package com.rule.problem.tags.doublepoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Simple {


    /**
     * 26. 删除有序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        //[0,0,1,1,1,2,2,3,3,4]
        //[0,1,2,3,4]
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int j = 0;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            if (nums[j] != nums[i]) {
                nums[j + 1] = nums[i];
                ans++;
                j++;
            }
        }
        return ans;
    }

    /**
     * 27. 移除元素
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int ans = 0;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 88. 合并两个有序数组
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 3,4,5 6, || 1,2,3
        int a = m - 1;
        int b = n - 1;
        int i = m + n - 1;
        while (i >= 0) {
            if (a == -1) {
                nums1[i] = nums2[b--];
            } else if (b == -1) {
                nums1[i] = nums1[a--];
            } else {
                nums1[i] = nums1[a] > nums2[b] ? nums1[a--] : nums2[b--];
            }
            i--;
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

    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    static {
        for (char c : vowels) {
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }

    /**
     * 345. 反转字符串中的元音字母
     */
    public String reverseVowelsII(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (hash[cs[l] - ' '] && hash[cs[r] - ' ']) {
                swap(cs, l++, r--);
            } else {
                if (!hash[cs[l] - ' ']) l++;
                if (!hash[cs[r] - ' ']) r--;
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
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
     * 485. 最大连续 1 的个数
     */
    public int findMaxConsecutiveOnesII(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return Math.max(max, sum);
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

    /**
     * 594. 最长和谐子序列
     */
    public int findLHSII(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) {
                i++;
            }
            if (nums[j] - nums[i] == 1) {
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

    /**
     * 832. 翻转图像
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int a = image.length;
        int b = image[0].length;

        int[][] ans = new int[a][b];
        for (int i = 0; i < a ; i++) {
            for (int j = b - 1; j >= 0; j--) {
                ans[i][b-j-1] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return ans;
    }


    /**
     * 重点 1221. 分割平衡字符串
     */
    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int[] sum = new int[chars.length + 1];
        int i = 0;
        sum[0] = 0;
        for (char aChar : chars) {
            int num = aChar == 'L' ? 1 : -1;
            sum[i + 1] = sum[i] + num;
            i++;
        }
        int ans = 0;
        for (int j = 1; j < sum.length; j++) {
            if (sum[j] == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 1446. 连续字符
     */
    public int maxPower(String s) {
        int ans = 1;
        int sum = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                sum++;
            } else {
                ans = Math.max(ans, sum);
                sum = 1;
            }
        }
        return Math.max(ans, sum);
    }

    /**
     * 1446. 连续字符
     */
    public int maxPowerII(String s) {
        int ans = 1;
        int sum = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                sum++;
            } else {
                ans = Math.max(ans, sum);
                sum = 1;
            }
        }
        return Math.max(ans, sum);
    }

    public int minSwaps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] temp = new int[n];
        int right = n - 1;
        while (right >= 0 && nums[right] == 1) {
            right--;
        }
        for (int i = 0; i < n; i++) {
            right++;
            if (right == n) {
                right = 0;
            }
            temp[i] = nums[right];
        }
        int[] sum = new int[n];

        return ans;
    }

    public static void main(String[] args) {
//        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
            balancedStringSplit("RLRRLLRLRL");
    }

}
