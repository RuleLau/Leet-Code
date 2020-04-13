package com.rule.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaxConsecutiveOnes {

    /**
     * 485. 最大连续 1 的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[1]) {
            return new int[]{1, 2};
        }
        int[] a = new int[2];
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                a[0] = nums[i];
            }
            if (i + 1 != nums[i] && flag == 0) {
                a[1] = i + 1;
                flag = 1;
            }
        }
        return a;
    }

}
