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
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(Character.getNumericValue(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            int a = Character.getNumericValue(chars[i]);
            if (flag == 1) {
                if (a >= stack.peek()) {
                    stack.add(a);
                } else {
                    int size = stack.size();
                    while (!stack.isEmpty()) {
                        Integer peek = stack.peek();

                    }
                    stack.push(a - 1);
                    for (int j = 0; j < size - stack.size(); j++) {
                        stack.add(9);
                    }
                    flag = 0;
                }
            } else {
                stack.add(9);
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.poll());
        }
        return Integer.parseInt(ans.toString());
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(668841));
    }

}
