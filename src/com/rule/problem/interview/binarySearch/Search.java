package com.rule.problem.interview.binarySearch;

/**
 * 33. 搜索旋转排序数组
 */
public class Search {

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                if (target > nums[mid] || target < nums[right]) {
                    left = mid + 1;
                }else if (target < nums[mid]){
                    right = mid - 1;
                }
            }else if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 2));
    }
}
