package com.rule.problem.practice;

/**
 * @description: 34. Find First and Last Position of Element in Sorted Array
 * @author: rule
 * @date: 2020-01-27 22:04
 **/
public class FindPositionSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int min = -1;
        int max = -1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (index != -1) {
            int old = index;
            while (old >= 0 && nums[old] == target) {
                min = old;
                old--;
            }
            old = index;
            while (old < nums.length && nums[old] == target) {
                max = old;
                old++;
            }
        }
        System.out.println(min + "::" + max);
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(nums, 6));
    }
}
