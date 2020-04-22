package com.rule.problem.interview.array;

/**
 * 011. 盛最多水的容器
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int l = height[left];
            int r = height[right];
            if (l < r) {
                left++;
            }else if (l > r) {
                right--;
            }else {
                left++;
                right--;
            }
            int area = width * Math.min(l, r);
            max = Math.max(area, max);
        }
        return max;
    }
}
