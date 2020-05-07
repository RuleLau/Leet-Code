package com.rule.problem.interview.string;

public class MyAtoi {

    public static int myAtoi(String str) {
        String replace = str.trim();
        int len = replace.length();
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < len; i++) {
            if (i == 0 && (replace.charAt(0) == '-' || replace.charAt(0) == '+')) {
                s.append(replace.charAt(0));
            } else {
                char c = replace.charAt(i);
                if (c >= '0' && c <= '9') {
                    int length = s.length();
                    if (c == '0' && ((length == 1 && s.charAt(0) == '0')
                        || (length == 2 && ((s.charAt(0) == '-' || s.charAt(0) == '+')
                        && s.charAt(1) == '0')))) {
                        continue;
                    }
                    s.append(c);
                } else {
                    break;
                }
            }
        }
        if (s.length() <= 11) {
            if ("".contentEquals(s) || "-".contentEquals(s) || "+".contentEquals(s)) {
                return 0;
            }
            long aLong = Long.parseLong(s.toString());
            if (aLong <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (aLong >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.parseInt(s.toString());
            }
        } else {
            if (s.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" -1010023630o4"));
        System.out.println(-2147483647 < Integer.MIN_VALUE);
    }
}
