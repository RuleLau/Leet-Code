package com.rule.problem.interview.binarySearch;

/**
 * 162. 寻找峰值
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (right - left == 1) {
                return nums[left] > nums[right] ? left : right;
            }

            if (mid == 0 || mid == len - 1) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            }

            if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            }

            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                if (nums[mid + 1] > nums[mid - 1]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{3,4,3,2,1}));
    }
}
