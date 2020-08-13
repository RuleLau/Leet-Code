package com.rule.problem.interview.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 856. 括号的分数
 */
public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }

}
