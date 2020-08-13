package com.rule.problem.interview.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 394. 字符串解码
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> leftStack = new ArrayDeque<>();
        Queue<Integer> rightStack = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '[') {
                leftStack.push(i);
            }else if (s.charAt(i) == ']') {
                rightStack.add(i);
            }
        }
        int size = leftStack.size();


        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> rightStack = new ArrayDeque<>();
        rightStack.add(1);
        rightStack.add(2);
        System.out.println(rightStack.poll());
    }
}
