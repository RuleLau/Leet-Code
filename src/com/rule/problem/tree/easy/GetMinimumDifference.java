package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

import java.util.Set;
import java.util.TreeSet;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {
    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        Set<Integer> set = new TreeSet<>();
        dfs(root);
        return min;
    }

    private void dfs( TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        dfs(root.right);
    }
}
