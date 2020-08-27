package com.rule.problem.interview.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: rule
 * @date: 2020-08-20 23:01
 **/
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int t =  0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (t == k) {
                return nums[i];
            }
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            t++;
        }
        return nums[0];
    }
}
