package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += (root.left.left == null && root.left.right == null) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !(root.right.left == null && root.right.right == null) ) {
            ans += dfs(root.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SumOfLeftLeaves s = new SumOfLeftLeaves();
        s.sumOfLeftLeaves(root);
    }
}
