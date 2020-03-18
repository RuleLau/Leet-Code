package com.rule.problem.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
            Collections.sort(values);
            return buildBST(0, values.size() - 1, values);
        }

        private TreeNode buildBST(int left, int right, List<Integer> values) {
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(values.get(mid));
            root.left = buildBST(left, mid - 1, values);
            root.right = buildBST(mid + 1, right, values);
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

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Map<Integer, Integer> speedMap = new HashMap<>();
        Map<Integer, Integer> efficMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            speedMap.put(speed[i], efficiency[i]);
            efficMap.put(efficiency[i], speed[i]);
        }
        Set<Integer> sp = new HashSet<>();
        Arrays.sort(speed);
        Arrays.sort(efficiency);
        for (int i = n - 1; i >= n - k + 1; i--) {
            sp.add(speed[i]);
            sp.add(efficMap.get(efficiency[i]));
        }
        int max = Integer.MIN_VALUE;
        Integer[] spArr = sp.toArray(new Integer[sp.size()]);
        for (Integer s : spArr) {

        }


        return 0;
    }

    private int findMin(int[] a) {

        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(luckyNumbers(new int[][]{{1,10,4,2}, {9,3,8,7}, {15,16,17,12}}));

    }
}
