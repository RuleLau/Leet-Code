package com.rule.problem.interview.sort;

/**
 * 75. 颜色分类
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int right = nums.length - 1;
        int k = 0;
        int i = 0;
        int temp;
        while (i <= right) {
            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right--] = 2;
            } else if (nums[i] == 0) {
                temp = nums[k];
                nums[k++] = nums[i];
                nums[i++] = temp;
            }else {
                i++;
            }
        }
    }
}
