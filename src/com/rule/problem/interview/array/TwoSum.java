package com.rule.problem.interview.array;

import java.util.*;

public class TwoSum {

    /**
     * 001. 两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (temp.containsKey(a) && temp.get(a) != i) {
                result[0] = i;
                result[1] = temp.get(a);
                break;
            }
        }
        return result;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     */
    public int[] twoSumII(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //twoSum(new int[]{3, 3}, 6);
    }
}
