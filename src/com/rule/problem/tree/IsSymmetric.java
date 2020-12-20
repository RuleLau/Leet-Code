package com.rule.problem.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 101. 对称二叉树
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return bfs(root);
    }

    private boolean bfs(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = deque.poll();
                list.add(head.val);
                if (head.val == Integer.MAX_VALUE) {
                    continue;
                }
                if (head.left != null) {
                    deque.add(head.left);
                }else {
                    deque.add(new TreeNode(Integer.MAX_VALUE));
                }
                if (head.right != null) {
                    deque.add(head.right);
                }else {
                    deque.add(new TreeNode(Integer.MAX_VALUE));
                }
            }
            if (!compare(list)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(List<Integer> list) {
        if (list.size() <= 1) {
            return true;
        }
        if (list.size() % 2 == 1) {
            return false;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) == null && list.get(right) != null) {
                return false;
            }
            if (list.get(left) != null && list.get(right) == null) {
                return false;
            }
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        isSymmetric.isSymmetric(treeNode);
    }

}
