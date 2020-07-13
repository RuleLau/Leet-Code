package com.rule.problem.interview.binarySearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            }else if (target > nums[mid]){
                left = mid + 1;
            }else {

            }
        }


        return new int[]{-1, -1};
    }
}
