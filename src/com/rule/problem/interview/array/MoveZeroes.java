package com.rule.problem.interview.array;


import java.util.Arrays;

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

    public static void moveZeroes2(int[] nums) {
        // 0,1,0,3,12
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
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

    public static void main(String[] args) {
        moveZeroes2(new int[]{0,1,0,3,12});
    }
}
