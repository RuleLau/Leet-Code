package com.rule.problem.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        return dfs(nums, 0 , len - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < 0 || right > nums.length) {
            return null;
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, 0, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

}
