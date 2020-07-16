package com.rule.problem.interview.binarySearch;

public class FindMin2 {

    //[3,3,3,3,3,3,3,3,1,3]
    public static int findMin(int[] nums) {
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            } else if (nums[mid] == nums[right] && nums[mid] == nums[left]) {
                left = left + 1;
            } else if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
                if (right - left == 2) {
                    break;
                }
                right = mid + 1;
            } else if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5}));
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(findMin(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3}));
        System.out.println(findMin(new int[]{1, 3, 3}));
        System.out.println(findMin(new int[]{3, 1, 1}));
        System.out.println(findMin(new int[]{10,1,10,10,10}));
        System.out.println(findMin(new int[]{2,2,2,0,1}));
    }
}
