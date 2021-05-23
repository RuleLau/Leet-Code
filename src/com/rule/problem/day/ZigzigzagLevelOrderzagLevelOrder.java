package com.rule.problem.day;


import com.rule.problem.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class ZigzigzagLevelOrderzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int i = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                TreeNode curr = deque.poll();
                if (curr.left != null) {
                    deque.add(curr.left);
                }
                if (curr.right != null) {
                    deque.add(curr.right);
                }
            }

            ans.add(i % 2 == 0 ? list : swap(list));
            i++;
        }
        return ans;
    }

    private List<Integer> swap(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
        return ans;
    }

}
