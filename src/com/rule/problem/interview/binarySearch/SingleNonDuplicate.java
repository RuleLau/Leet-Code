package com.rule.problem.interview.binarySearch;

/**
 * 540. 有序数组中的单一元素
 */
public class SingleNonDuplicate {


    /**
     * 暴力法
     */
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[nums.length - 1];
    }
    public static void main(String[] args) {

    }
}
