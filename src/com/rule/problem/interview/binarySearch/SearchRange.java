package com.rule.problem.interview.binarySearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right && left >= 0 && right < nums.length) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;
                if (mid != 0) {
                    while (left > 0) {
                        if (nums[--left] != target) {
                            left++;
                            break;
                        }
                    }
                }
                if (mid != nums.length - 1) {
                    while (right < nums.length - 1) {
                        if (nums[++right] != target) {
                            right--;
                            break;
                        }
                    }
                }
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 3)));
    }
}
