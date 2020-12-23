package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

/**
 * 226. 翻转二叉树
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        dfs(root.left);
        dfs(root.right);
    }

}
