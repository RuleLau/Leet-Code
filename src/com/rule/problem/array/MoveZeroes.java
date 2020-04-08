package com.rule.problem.array;


public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                temp[right--] = 0;
            } else {
                temp[left++] = num;
            }
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
