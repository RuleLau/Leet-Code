package com.rule.problem.practice;

import java.util.Arrays;

/**
 * @description: 26. Remove Duplicates from Sorted Array
 * @author: rule
 * @date: 2019-11-30 14:33
 **/
public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
