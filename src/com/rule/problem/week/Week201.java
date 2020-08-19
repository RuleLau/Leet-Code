package com.rule.problem.week;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: week-201
 * @author: rule
 * @date: 2020-08-15 21:36
 **/
public class Week201 {

    /**
     * 1544. 整理字符串
     */
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            char one = sb.charAt(i);
            char two = sb.charAt(i + 1);
            if ((Character.toUpperCase(one) == Character.toUpperCase(two)) && one != two) {
                sb.replace(i, i + 2, "");
                return makeGood(sb.toString());
            }
        }
        return sb.toString();
    }

    /**
     * 1545. Find Kth Bit in Nth Binary String
     */
    public static char findKthBit(int n, int k) {
        StringBuilder[] s = new StringBuilder[n];
        s[0] = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            StringBuilder last = s[i - 1];
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < last.length(); j++) {
                char c = last.charAt(j);
                temp.append(c == '0' ? "1" : "0");
            }
            s[i] = s[i - 1].append("1").append(temp.reverse());
        }
        return s[n - 1].charAt(k - 1);
    }

    /**
     * 1546. 和为目标值的最大数目不重叠非空子数组数目
     */
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int curSum = 0;
        int res = 0;
        set.add(0);
        for (int num : nums) {
            curSum += num;
            if (set.contains(curSum - target)) {
                set.clear();
                set.add(0);
                curSum = 0;
                res++;
            } else {
                // 还未满足条件，保留当前段的和
                set.add(curSum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(makeGood("Pp"));
        //System.out.println(findKthBit(2, 3));
        //System.out.println((String.valueOf('1' ^ '1')));
    }
}
