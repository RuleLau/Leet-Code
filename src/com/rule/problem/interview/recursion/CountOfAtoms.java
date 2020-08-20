package com.rule.problem.interview.recursion;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * 726. 原子的数量
 */
public class CountOfAtoms {

    public static String countOfAtoms(String formula) {
        Map<String, Integer> tree = new TreeMap<>();
        Deque<String> stack = new ArrayDeque<>();
        int len = formula.length();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = formula.charAt(i);
            if (c == ')') {
                int num = 1;
                s.setLength(0);
                while (i != len - 1 && checkNumber(formula.charAt(i + 1))) {
                    s.append(formula.charAt(++i));
                }
                num = s.length() == 0 ? num : Integer.parseInt(s.toString());
                Deque<String> temp = new ArrayDeque<>();
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    String pop = stack.pop();
                    if (checkNumber(pop.charAt(0))) {
                        temp.push(String.valueOf(Integer.parseInt(pop) * num));
                        temp.push(stack.pop());
                    } else {
                        temp.push(num + "");
                        temp.push(pop);
                    }
                }
                if ("(".equals(stack.peek())) {
                    stack.pop();
                }
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            } else {
                String a = String.valueOf(c);
                if (checkxx(c)) {
                    String pop = stack.pop();
                    a = pop + c;
                    stack.push(a);
                } else if (checkNumber(c)) {
                    s.setLength(0);
                    while (i != len && checkNumber(formula.charAt(i))) {
                        s.append(formula.charAt(i++));
                    }
                    i--;
                    stack.push(s.toString());
                } else {
                    stack.push(a);
                }
            }
        }
        while (!stack.isEmpty()) {
            String c = stack.pop();
            if (checkNumber(c.charAt(0))) {
                tree.put(stack.peek(), tree.getOrDefault(stack.pop(), 0) + Integer.parseInt(c));
            }else {
                tree.put(c, tree.getOrDefault(c, 0) + 1);
            }
        }
        s.setLength(0);
        tree.forEach((k, v) -> {
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
        System.out.println(countOfAtoms("H11He49NO35B7N46Li20"));
    }
}

