package com.rule.problem.practice;

/**
 * @description: 8 String to Integer (atoi)
 * @author: rule
 * @date: 2019-10-09 23:11
 **/
public class String2Integer {

    // mine
    public static int myAtoi(String str) {
        char opreator = '+';
        String result = "";
        // 判断str合法性
        while (str.startsWith(" ")) {
            str = str.replaceFirst(" ", "");
        }
        if (str.length() < 1) {
            return 0;
        }
        if (str.charAt(0) == '-') {
            opreator = '-';
            if (str.length() > 1) {
                str = str.split("-")[1];
            } else {
                return 0;
            }
        } else if (str.charAt(0) == '+') {
            opreator = '+';
            if (str.length() > 1) {
                str = str.split("\\+")[1];
            } else {
                return 0;
            }
        }
        if (str.length() > 0 && !(str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
            return 0;
        }
        int i = 0;
        result += opreator;
        while (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result += str.charAt(i);
            } else if (result.length() > 1 && !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            }
            i++;
        }
        while (result.length() > 1 && result.substring(1).startsWith("0")) {
            result = result.replaceFirst("0", "");
        }
        if (opreator == '+') {
            if (result.length() > 12) {
                return Integer.MAX_VALUE;
            }
        } else {
            if (result.length() > 12) {
                return Integer.MIN_VALUE;
            }
        }
        Long value = 0L;
        if (result.length() > 1) {
            value = Long.valueOf(result);
            if (value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return value.intValue();
    }

    // other's good solution
    public static int myAtoi1(String str) {
        long max = Integer.MAX_VALUE;

        //states initialization
        int charLen = str.length();
        int index = 0;
        int initFound = 1;

        while (index < charLen && str.charAt(index) == ' ') {
            index++;
        }

        if (index < charLen && str.charAt(index) == '-') {
            index++;
            initFound = -1;
        } else if (index < charLen && str.charAt(index) == '+') {
            index++;
        }

        long solution = 0;
        int base = '0';

        while (index < charLen && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            solution = solution * 10 + str.charAt(index) - base;

            if (solution > max && initFound == 1) {
                return (int) max * initFound;
            }

            if (solution > max + 1 && initFound == -1) {
                return (int) (max + 1) * initFound;
            }
            index++;
        }

        return (int) solution * initFound;
    }

    public static void main(String[] args) {
        String str = "++C";
        System.out.println(myAtoi(str));
        //System.out.println(str.substring(1));
    }
}
