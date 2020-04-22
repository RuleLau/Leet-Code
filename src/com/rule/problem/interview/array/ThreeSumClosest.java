package com.rule.problem.interview.array;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * 016. 最接近的三数之和
     */
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int temp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int a = nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                int value = Math.abs(target - sum);
                if (value < min) {
                   min = value;
                   temp = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(temp);
        return temp;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{-1, 0, 1, 1, 55}, 3);
    }
}
