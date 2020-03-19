package com.rule.problem.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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

    /**
     * 1383. Maximum Performance of a Team
     */
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        // 根据efficiency降序排列
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long res = Long.MIN_VALUE;
        long totalSpeed = 0;
        for (int[] engineer : engineers) {
            if (pq.size() == k) {
                totalSpeed -= pq.poll();
            }
            int sp = engineer[1];
            int eff = engineer[0];
            pq.add(sp);
            totalSpeed += sp;
            res = Math.max(res, totalSpeed * eff);
        }
        return (int) (res % MOD);
    }


    public static void main(String[] args) {
        //System.out.println(luckyNumbers(new int[][]{{1,10,4,2}, {9,3,8,7}, {15,16,17,12}}));
        maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 2);
    }
}
