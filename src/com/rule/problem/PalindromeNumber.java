package com.rule.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * @author: rule
 * @date: 2019-10-10 23:33
 **/
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();
        // 判断x的正负
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        String value = String.valueOf(x);
        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int p = x;
        int q = 0;
        while (p >= 10) {
            q *= 10;
            q += p % 10;
            p /= 10;
        }
        return q == x / 10 && p == x % 10;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }
}
