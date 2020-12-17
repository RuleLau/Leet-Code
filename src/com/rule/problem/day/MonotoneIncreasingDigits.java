package com.rule.problem.day;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotoneIncreasingDigits {

    //668841 667999
    public static int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        String s = Integer.toString(N);
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int flag = 1;
        int len = chars.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Character.getNumericValue(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            int a = Character.getNumericValue(chars[i]);
            if (flag == 1) {
                if (a >= stack.peek()) {
                    stack.push(a);
                } else {
                    int size = stack.size();
                    a = stack.pop();
                    while (!stack.isEmpty() && a == stack.peek()) {
                        a = stack.pop();
                    }
                    stack.push(a - 1);
                    for (int j = 0; j <= size - stack.size() + 1; j++) {
                        stack.push(9);
                    }
                    flag = 0;
                }
            } else {
                stack.push(9);
            }
        }
        while (stack.size() < len) {
            stack.push(9);
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pollLast());
        }
        return Integer.parseInt(ans.toString());
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(9999998));
    }

}
