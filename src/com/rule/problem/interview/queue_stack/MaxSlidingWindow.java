package com.rule.problem.interview.queue_stack;

import java.util.Arrays;

/**
 * hard
 * @description: 239. 滑动窗口最大值
 * @author: rule
 * @date: 2020-08-12 22:11
 **/
public class MaxSlidingWindow {


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = i % k == 0 ? nums[i] : Integer.max(left[i - 1], nums[i]);
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                right[i] = nums[i];
            } else {
                right[i] = (i + 1) % k == 0 ? nums[i] : Integer.max(right[i + 1], nums[i]);
            }
        }

        for (int i = 0; i < len - k + 1; i++) {
            int j = i + k - 1;
            res[i] = Integer.max(left[j], right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
