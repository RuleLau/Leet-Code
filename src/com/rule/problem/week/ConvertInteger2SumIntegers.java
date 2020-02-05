package com.rule.problem.week;

/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers
 * @author liurui-1
 * @date 2020/1/15 15:38
 * @version 1.0.0
 */
public class ConvertInteger2SumIntegers {

    public static void main(String[] args) {
        getNoZeroIntegers(1010);
    }
    public static int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - 1;
        while (isHasZero(left) || isHasZero(right)) {
            left++;
            right--;
        }
        return new int[]{left, right};
    }

    private static boolean isHasZero(int num) {
        while (num != 0) {
            int n = num % 10;
            if (n == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}


