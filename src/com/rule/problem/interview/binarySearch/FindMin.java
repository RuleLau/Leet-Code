package com.rule.problem.interview.binarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public static int findMin(int[] nums) {
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                if (right - left == 2) {
                    break;
                }
                right = mid + 1;
            } else if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            }
            mid = (left + right) / 2;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{3,4,5,6,0,1,2}));
        System.out.println(findMin(new int[]{2, 3, 4, 5, 1}));
    }

}
