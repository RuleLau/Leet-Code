package com.rule.problem.interview.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 394. 字符串解码
 */
public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Queue<Integer> rightStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                leftStack.push(i);
            } else if (s.charAt(i) == ']') {
                rightStack.add(i);
            }
            if (!leftStack.isEmpty() && !rightStack.isEmpty()) {
                int left = leftStack.pop();
                int right = rightStack.poll();
                int last = left - 1;
                int num = 0;
                int n = 1;
                while (last >= 0 && s.charAt(last) >= '0' && s.charAt(last) <= '9') {
                    char c = s.charAt(last);
                    num += n * (Integer.parseInt(String.valueOf(c)));
                    n = n * 10;
                    last--;
                }
                StringBuilder str = new StringBuilder();
                num = num == 0 ? 1 : num;
                String s1 = s.substring(left + 1, right);
                for (int j = 0; j < num; j++) {
                    str.append(s1);
                }
                // 重新赋值
                s = s.substring(0, last == -1 ? 0 : last + 1)
                        + str
                        + (right == s.length() - 1 ? "" : s.substring(right + 1, s.length()));
                return decodeString(s);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("[a]"));
    }
}
