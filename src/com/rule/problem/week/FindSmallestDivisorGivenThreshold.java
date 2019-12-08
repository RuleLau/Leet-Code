package com.rule.problem.week;

/**
 * @description: week 166 1283. Find the Smallest Divisor Given a Threshold
 * @author: rule
 * @date: 2019-12-08 20:41
 **/
public class FindSmallestDivisorGivenThreshold {

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) 1e6;
        while (left < right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : nums) {
                sum += (i + m - 1) / m;
            }
            if (sum > threshold) {
                left = m + 1;
            }
            else {
                right = m;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 7, 11};
        System.out.println(smallestDivisor(nums, 11));
    }
}
