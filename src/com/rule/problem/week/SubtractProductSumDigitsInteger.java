package com.rule.problem.week;

/**
 * @description: week 166 1281. Subtract the Product and Sum of Digits of an Integer
 * @author: rule
 * @date: 2019-12-08 20:06
 **/
public class SubtractProductSumDigitsInteger {

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;

        while (n != 0) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }
        return mul - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(1024));
    }
}
