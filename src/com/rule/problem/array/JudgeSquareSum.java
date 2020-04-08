package com.rule.problem.array;

/**
 * 633. 平方数之和
 */
public class JudgeSquareSum {


    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }else if (sum < c) {
                left++;
            }else {
                right--;
            }
        }
        return false;
    }
}
