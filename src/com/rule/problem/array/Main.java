package com.rule.problem.array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class Main {


    /**
     * 双指针判断，如果nums[i]!=nums[j],说明i-j之间存在重复项，然后将nums[j + 1] = nums[i]，
     * 进行元素的重新赋值，这也是删除重复项
     * 26. 删除有序数组中的重复项
     */
    public static int removeDuplicates(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int ans = 1;
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                nums[j + 1] = nums[i];
                j++;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 27. 移除元素，双指针，遍历不等于val的值的元素，则将该元素赋值给
     * j下标的元素（重复的元素），执行完赋值后，则j++,i++;
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int j = 0;
        int ans = len;

        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;

            } else {
                ans--;
            }
        }
        return ans;
    }

    /**
     * 66. 加一, 情况分为9和非9情况，如果为9则进1，否则直接返回
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
