package com.rule.problem.practice;

import java.util.Arrays;

/**
 * @description: 16. 3Sum Closest
 * @author: rule
 * @date: 2019-11-25 22:52
 **/
public class SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int sum;
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - min) >= Math.abs(target - sum)) {
                    min = sum;
                    if (min == target) {
                        return target;
                    }
                }
                if (sum > target) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
