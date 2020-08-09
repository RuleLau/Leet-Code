package com.rule.problem.interview.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 */
public class ValidCharacter {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            }else {
                if (deque.isEmpty()) {
                    return false;
                }else {
                    char p = deque.pop();
                    if (!(p == '(' && c == ')' || p == '[' && c == ']' || p == '{' && c == '}')) {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();
    }

    private boolean valid(char first, char second) {
        return first == '(' && second == ')'
            || first == '[' && second == ']'
            || first == '{' && second == '}';
    }

}
