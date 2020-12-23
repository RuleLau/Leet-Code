package com.rule.problem.tree.easy;

import com.rule.problem.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 100. 相同的树
 */
public class IsSameTree {

    public boolean isSameTree2(TreeNode p, TreeNode q) {
       if (p == null && q == null) {
           return true;
       }
       if (p == null || q == null) {
           return false;
       }
       if (p.val == q.val) {
           return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
       }
       return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pi = new ArrayList<>();
        List<Integer> qi = new ArrayList<>();
        dfs(p, pi);
        dfs(q, qi);
        if (pi.size() != qi.size()) {
            return false;
        }
        for (int i = 0; i < pi.size(); i++) {
            Integer a = pi.get(i);
            Integer b = qi.get(i);
            if (a != null && b != null && !a.equals(b)) {
                return false;
            }
            if ((a != null && b == null) || (a == null && b != null)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
