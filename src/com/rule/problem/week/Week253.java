package com.rule.problem.week;

import java.util.ArrayDeque;

public class Week253 {

    public int minSwaps(String s) {
        //"][[]][][[][]"
        int ans = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>(s.length() / 2);
        s = replaceChar(s, stack);
        if (s.length() == 0) {
            return ans;
        }
        // ]]]][[[[
        while (s.length() != 0) {
            stack.clear();
            if (s.length() > 2) {
                s = s.substring(2, s.length() - 2);
                ans++;
            } else {
                return ans + 1;
            }
            s = replaceChar(s, stack);
        }
        return ans;
    }
    //"][[]"
    private static String replaceChar(String s, ArrayDeque<Character> stack) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.isEmpty() && stack.peek() == '[' && aChar == ']') {
                stack.pop();
                continue;
            }
            stack.push(aChar);
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollLast());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
      String s = "]]]][[[[";
          /*s = "[" + s.substring(1, s.length() - 1) + "]";
        System.out.println(s);*/
//        System.out.println(replaceChar("][[]][][[][]"));;
        System.out.println(s.substring(2, s.length() - 2));
    }
}
