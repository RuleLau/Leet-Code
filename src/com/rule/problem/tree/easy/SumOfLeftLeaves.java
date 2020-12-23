package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            return sum + root.val;
        }
        sum += dfs(root.left, 0);
        sum += dfs(root.right, 0);
        return sum;
    }

}
