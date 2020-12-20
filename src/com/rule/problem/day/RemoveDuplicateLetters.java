package com.rule.problem.day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[256];
        for (char c : chars) {
            count[c]++;
        }
        boolean[] inStack = new boolean[256];
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (char curr : chars) {
            count[curr]--;
            if (inStack[curr]) {
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() > curr) {
                if (count[deque.peekLast()] == 0) {
                    break;
                }
                inStack[deque.pollLast()] = false;
            }
            deque.add(curr);
            inStack[curr] = true;
        }
        while (!deque.isEmpty()) {
            ans.append(deque.poll());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters("cdadabcc"));
    }

}
