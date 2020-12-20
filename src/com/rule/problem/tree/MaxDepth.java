package com.rule.problem.tree;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int res) {
        if (root == null) {
            return res;
        }
        int left = dfs(root.left, res + 1);
        int right = dfs(root.right, res + 1);
        return Math.max(left, right);
    }
}
