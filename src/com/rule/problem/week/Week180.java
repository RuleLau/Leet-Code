package com.rule.problem.week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week180 {

    /**
     * 1380. Lucky Numbers in a Matrix
     */
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int min;
        int max;
        int idx = 0;
        for (int i = 0; i < row; i++) {
            min = matrix[i][0];
            for (int j = 1; j < col; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    idx = j;
                }
            }
            max = matrix[0][idx];
            for (int j = 0; j < row; j++) {
                max = Math.max(max, matrix[j][idx]);
            }
            if (min == max) {
                res.add(min);
            }
        }

        return res;
    }

    /**
     * 1381. Design a Stack With Increment Operation
     */
    public static class CustomStack {

        private int[] stack;

        private int index = 0;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
        }

        public void push(int x) {
            if (index >= stack.length) {
                return;
            }
            stack[index++] = x;
        }

        public int pop() {
            if (stack == null || index == 0) {
                return -1;
            }
            return stack[--index];
        }

        public void increment(int k, int val) {
            int count = index < k ? index : k;
            for (int i = 0; i < count; i++) {
                stack[i] += val;
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode balanceBST(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            dfs(root, values);
            int len = values.size();
            Collections.sort(values);


            return root;
        }

        public void dfs(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            values.add(root.val);
            dfs(root.left, values);
            dfs(root.right, values);
        }
    }

    public static void main(String[] args) {
        //System.out.println(luckyNumbers(new int[][]{{1,10,4,2}, {9,3,8,7}, {15,16,17,12}}));

    }
}
