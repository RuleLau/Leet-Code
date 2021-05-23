package com.rule.problem.tree.easy;

public class NTreeMaxDepth {
    public int maxDepth(Node root) {

        return dfs(root, 0);
    }


    private int dfs(Node root, int depth) {
        return depth;
    }
}
