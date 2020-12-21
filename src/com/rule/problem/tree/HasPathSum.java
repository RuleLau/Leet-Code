package com.rule.problem.tree;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum)  == 0;
    }

    private int dfs(TreeNode root, int sum) {
        int ans = -1;
        if (root.left == null && root.right == null && sum == root.val) {
            return 0;
        }
        if (root.left != null) {
            ans = dfs(root.left, sum - root.val);
        }
        if (ans == 0) {
            return 0;
        }
        if (root.right != null) {
            ans = dfs(root.right, sum - root.val);
        }
        if (ans == 0) {
            return 0;
        }
        return -1;
    }
}
