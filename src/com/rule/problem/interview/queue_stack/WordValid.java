package com.rule.problem.interview.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: rule
 * @date: 2020-08-08 08:24
 **/
public class WordValid {

    public static boolean isValid(String S) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'c') {
                if (deque.isEmpty()) {
                    return false;
                }
                char b = deque.pop();
                if (b == 'b') {
                    if (deque.isEmpty()) {
                        return false;
                    }
                    char a = deque.pop();
                    if (a != 'a') {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        isValid("aabcbc");
    }
}
