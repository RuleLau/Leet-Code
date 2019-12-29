package com.rule.problem;

import java.util.Arrays;

/**
 * @description: 31. Next Permutation
 * @author: rule
 * @date: 2019-12-02 22:05
 **/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void nextPermutation1(int[] nums) {
        if (nums.length >= 2) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i == 0) {
                    Arrays.sort(nums);
                    break;
                }
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, nums.length );
                    //遍历
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        n.nextPermutation1(nums);
        System.out.println(Arrays.toString(nums));
        //1 5 8 5 7 6 4 3 1
        //1 5 8 5
    }

}
