package com.rule.problem.algorithm;

/**
 * @description:
 * @author: rule
 * @date: 2020-12-08 19:20
 **/
public class BinarySearch {

    //递推
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //递归方式
    public int searchII(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return dfs(nums, target, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int target, int low, int high)  {
        int mid = low + (high - low) / 2;
        if (low > high) {
            return  -1;
        }
        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] > target) {
            return dfs(nums, target, low, mid - 1);
        }else {
            return dfs(nums, target, mid + 1, high);
        }
    }

    public String toBinary(int num) {
        StringBuilder s = new StringBuilder();
        for (; num > 0; num /= 2) {
            s.insert(0, num % 2);
        }
        return s.toString();
    }

    public static int my(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return my(a + a,  b / 2);
        }
        return my(a + a, b / 2) + a;
    }
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
//        System.out.println(binarySearch.searchII(new int[]{1, 2, 3, 4, 5}, 1));
//        System.out.println(binarySearch.toBinary(9));
        System.out.println(my(2, 25));
        System.out.println(my(3, 11));
    }



}
