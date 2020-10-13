package com.rule.problem.week;

import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-10-12 08:58
 **/
public class Week209 {

    public int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= len) {
            return len;
        }
        if (nums[0] == 0) {
            return -1;
        }
        for (int i = 1; i < len; i++) {
            if (nums[len - i] >= i && nums[len - i - 1] < i) {
                return i;
            }
        }
        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }

    private boolean bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>(5000);
        Queue<TreeNode> queue = new ArrayDeque<>(5000);
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                ans.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (depth % 2 == 0) {
                if (ans.size() == 1 && ans.get(0) % 2 == 0) {
                    return false;
                }
                for (int i = 0; i < ans.size() - 1; i++) {
                    if (ans.get(i) % 2 == 0 || ans.get(i + 1) % 2 == 0 || ans.get(i + 1) <= ans.get(i)) {
                        return false;
                    }
                }
            }else {
                if (ans.size() == 1 && ans.get(0) % 2 == 1) {
                    return false;
                }
                for (int i = 0; i < ans.size() - 1; i++) {
                    if (ans.get(i) % 2 == 1 || ans.get(i + 1) % 2 == 1 || ans.get(i + 1) >= ans.get(i)) {
                        return false;
                    }
                }
            }
            ans.clear();
            depth++;
        }
        return true;
    }


}
