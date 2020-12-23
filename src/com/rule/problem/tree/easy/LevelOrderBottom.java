package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<List<Integer>> bfs = bfs(root);
        while (!bfs.isEmpty()) {
            res.add(bfs.pop());
        }
        return res;
    }

    private Deque<List<Integer>> bfs(TreeNode root) {
        Deque<List<Integer>> res = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = deque.poll();
                list.add(head.val);
                if (head.left != null) {
                    deque.add(head.left);
                }
                if (head.right != null) {
                    deque.add(head.right);
                }
            }
            res.push(list);
        }
        return res;
    }
}
