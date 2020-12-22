package com.rule.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: rule
 * @date: 2020-12-22 19:59
 **/
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private String dfs(List<String> res, TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null) {
            return str.toString();
        }
        str.append(root.val);
       if (root.left == null && root.right == null) {
           if (!"".equals(str.toString())) {
               res.add(str.toString());
           }
       }
       str.append(dfs(res, root.left) + "->");
       str.append(dfs(res, root.right) + "->");
       return str.toString();
    }

}
