package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return null;
        }
        int depth = 1;
        int pv = 0;
        int qv = 0;
        deque.add(root);
        map.put(root.val, Integer.MIN_VALUE);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.val == p.val) {
                    pv = depth;
                }
                if (poll.val == q.val) {
                    qv = depth;
                }
                if (poll.left != null) {
                    map.put(poll.left.val, poll.val);
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    map.put(poll.right.val, poll.val);
                    deque.add(poll.right);
                }
            }
            depth++;
        }
        System.out.println("pv: " + pv);
        System.out.println("qv: " + qv);
        int ans = 0;
        boolean flag = false;
        if (pv < qv) {
            while (pv != qv) {
                if (p.val == q.val) {
                    ans = p.val;
                    flag = true;
                    break;
                } else {
                    q.val = map.get(q.val);
                }
                qv--;
            }
        } else if (pv > qv) {
            while (pv != qv) {
                if (q.val == p.val) {
                    ans = q.val;
                    flag = true;
                    break;
                } else {
                    p.val = map.get(p.val);
                }
                pv--;
            }
        }
        if (!flag) {
            int p1 = p.val;
            int q1 = q.val;
            System.out.println("p1: " + p1);
            System.out.println("q1: " + q1);
            if (p1 == q1) {
                ans = p1;
            }else {
                while (pv != 1) {
                    if (map.get(p1).equals(map.get(q1))) {
                        ans = map.get(p1);
                        break;
                    } else {
                        p1 = map.get(p1);
                        q1 = map.get(q1);
                    }
                    pv--;
                }
            }

        }
        return new TreeNode(ans);
    }

}
