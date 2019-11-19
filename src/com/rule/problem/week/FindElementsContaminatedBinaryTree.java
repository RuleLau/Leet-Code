package com.rule.problem.week;

import javax.swing.tree.TreeNode;

/**
 * @description: 1261. Find Elements in a Contaminated Binary Tree
 * @author: rule
 * @date: 2019-11-17 16:23
 **/
public class FindElementsContaminatedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    TreeNode root;

    private void recoveryTree(TreeNode root, int val) {
        // 将受污染的树还原为正确的树
        if (root == null) {
            return ;
        }
        root.val = val;
        recoveryTree(root.left, 2 * val + 1);
        recoveryTree(root.right, 2 * val + 2);
    }


    public FindElementsContaminatedBinaryTree(TreeNode root) {
        this.root = root;
        // recovery tree
        recoveryTree(this.root, 0);
    }

    public static boolean find(int target) {
        TreeNode root = new TreeNode(0);
        FindElementsContaminatedBinaryTree tree = new FindElementsContaminatedBinaryTree(root);
        if (target < 0) {
            return false;
        }else {
            return queryTree(root, target);
        }
    }

    private static boolean queryTree(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val > target) {
            return false;
        }
        return queryTree(root.left, target) || queryTree(root.right, target);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        FindElementsContaminatedBinaryTree tree = new FindElementsContaminatedBinaryTree(root);
        System.out.println(queryTree(root, 3));
    }
}
