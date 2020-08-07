package com.rule.problem.interview.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 */
public class ValidCharacter {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            deque.push(c);
        }
        while (!deque.isEmpty()) {
            Character first = deque.pop();
            Character second = deque.pop();
            boolean v = valid(first, second);
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private boolean valid(Character first, Character second) {
        if (first == ')' && second == '('
                || first == '}' && second == '{'
                || first == ']' && second == '[') {
            return true;
        }
        return (first == ')' || first == ']' || first == '}')
                && (second == ')' || second == ']' || second == '}');
    }

}
