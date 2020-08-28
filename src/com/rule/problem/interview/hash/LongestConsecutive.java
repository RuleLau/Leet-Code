package com.rule.problem.interview.hash;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @description: 128. 最长连续序列
 * @author: rule
 * @date: 2020-08-28 09:55
 **/
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }else if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> tree = Arrays.stream(nums).parallel().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        Integer[] res = tree.toArray(new Integer[0]);
        int max = 0;
        int count = 1;
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i + 1] - res[i] == 1) {
                count++;
            }else {
                max = Integer.max(max, count);
                count = 1;
            }
            if (max > res.length / 2) {
                return max;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{0,1,7});
    }

}
