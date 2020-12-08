package com.rule.problem.hot100;

import java.util.*;

public class Hot100 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || root.val == 0) {
            return ans;
        }
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }

    // 层序遍历
    public void bfs(TreeNode root, List<Integer> ans) {
        Deque<TreeNode> deque = new ArrayDeque<>();




    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int min = heights[i];
            int left = i;
            int right = i;
            while (left > 0 && heights[left - 1] >= min) {
                min = Math.min(min, heights[left]);
                left--;
            }
            while (right < len - 1 && heights[right + 1] >= min) {
                min = Math.min(min, heights[right]);
                right++;
            }
            int width = right - left + 1;
            sum = Math.max(sum, width * min);
        }
        return sum;
    }

    public static void main(String[] args) {
        Hot100 hot100 = new Hot100();
        System.out.println(hot100.largestRectangleArea(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
    }
}
