package com.rule.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257 二叉树所有路径
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res, "", root);
        return res;
    }

    private void dfs(List<String> res, String path, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        dfs(res, path + root.val + "->", root.left);
        dfs(res, path + root.val + "->", root.right);
    }

}
