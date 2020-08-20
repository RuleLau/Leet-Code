package com.rule.problem.interview.recursion;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 726. 原子的数量
 */
public class CountOfAtoms {

    public static String countOfAtoms(String formula) {
        Map<String, Integer> tree = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        int len = formula.length();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = formula.charAt(i);
            if (c == ')') {
                int num = 1;
                while (++i != len && checkNumber(formula.charAt(i))) {
                    s.append(formula.charAt(i));
                }
                num = s.length() == 0 ? num : Integer.parseInt(s.toString());
                s.setLength(0);
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    String pop = stack.pop();
                    tree.put(pop, tree.getOrDefault(pop, 1) * num);
                }
                if ("(".equals(stack.peek())) {
                    stack.pop();
                }
            } else {
                String a = String.valueOf(c);
                if (checkxx(c)) {
                    String pop = stack.pop();
                    a = pop + c;
                    stack.push(a);
                }else if (checkNumber(c)) {
                    s.setLength(0);
                    while (i != len && checkNumber(formula.charAt(i))) {
                        s.append(formula.charAt(i++));
                    }
                    i--;
                    String word = stack.peek();
                    tree.put(word, tree.getOrDefault(word, 0) + Integer.parseInt(s.toString()));
                    s.setLength(0);
                }else {
                    stack.push(a);
                }
            }
        }


        tree.forEach((k,v) -> {
            s.append(k).append(v == 1 ? "" : v);
        });
        return s.toString();
    }

    public static boolean checkxx(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean checkNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
       System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
}

