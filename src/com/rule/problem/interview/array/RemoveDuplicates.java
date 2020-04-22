package com.rule.problem.interview.array;

public class RemoveDuplicates {

    // 1 1 2 3
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicatesII(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;

    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesII(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
