package com.rule.problem.algorithm.stack_queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 匹配括号
 * 匹配括号，表达式中判断左右括号是否匹配。
 */
public class StackAndQueue {

    /**
     * P1739
     * @param s
     */
    public static void piPei(String s) {

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        boolean flag = true;
        for (char aChar : chars) {
            if (!flag) {
                break;
            }

            if (aChar == '(') {
                stack.push(aChar);
            } else if (aChar == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println("可以匹配");
        } else {
            System.out.println("字符串非法，无法匹配");
        }

    }

    // UVA514
    public static void train(int n, int[] arrs) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int i = 1;
        while (i <= n && j < n) {
            if (i != arrs[j]) {
                stack.push(i++);
                continue;
            }

            if (i == arrs[j]) {
                j++;
            }
            while (!stack.isEmpty() && stack.peek() == arrs[j]) {
                stack.pop();
                j++;
            }

        }
        if (stack.isEmpty()) {
            System.out.println("合法的出站顺序");
        } else {
            System.out.println("不合法的出站顺序");
        }
    }

    public static class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    // UVA442
    public static void matrixLink(Map<Character, Matrix> martixMap, String str) {
        char[] chars = str.toCharArray();
        Stack<Matrix> stack = new Stack<>();
        int sum = 0;
        for (char aChar : chars) {
            Matrix matrix1 = martixMap.get(aChar);
            if (aChar == ')') {
                Matrix b = stack.pop();
                Matrix a = stack.pop();
                if (a.col != b.row) {
                    System.out.println("矩阵是不合法的");
                    break;
                }
                sum += b.row * b.col * a.row;
                stack.push(new Matrix(a.row, b.col));
            } else {
                if (aChar == '(') {
                    continue;
                }
                stack.push(matrix1);
            }
        }
        System.out.println(sum);
    }

    // UVA12100
    public static void printQueue(int[] arr, int target) {
        int n = arr.length;
//        Integer[] arrayCopy = new Integer[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> queue1 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
//            arrayCopy[i] = arr[i];
            queue.add(arr[i]);
            queue1.add(i);
        }
        int time = 0;
        while (!queue1.isEmpty() && !queue.isEmpty()) {
            Integer poll = queue1.poll();
            Integer max = queue.peek();
            if (arr[poll] < max) {
                queue1.add(poll);
            }

            if (arr[poll] == max) {
                queue.poll();
                time++;
                if (poll == target) {
                    break;
                }
            }



        }
        System.out.println(time);

    }


    public static void main(String[] args) {
//        piPei("(a+c)*b+(c+b))");
//        train(5, new int[]{5, 3, 4, 2, 1});
        Map<Character, Matrix> martixMap = new HashMap<>();
        martixMap.put('A', new Matrix(50, 10));
        martixMap.put('B', new Matrix(10, 20));
        martixMap.put('C', new Matrix(20, 5));
        martixMap.put('D', new Matrix(30, 35));
        martixMap.put('E', new Matrix(35, 15));
        martixMap.put('F', new Matrix(15, 5));
        martixMap.put('G', new Matrix(5, 10));
        martixMap.put('H', new Matrix(10, 20));
        martixMap.put('I', new Matrix(20, 25));
        matrixLink(martixMap, "((AB)C)");
        matrixLink(martixMap, "(A(BC))");
        matrixLink(martixMap, "(((((DE)F)G)H)I)");
        matrixLink(martixMap, "(D(E(F(G(HI)))))");
        matrixLink(martixMap, "((D(EF))((GH)I))");
        //
        printQueue(new int[]{1,1,9,1,1,1}, 0);
        printQueue(new int[]{1,2,3,4}, 2);
        printQueue(new int[]{5}, 0);
    }

}
