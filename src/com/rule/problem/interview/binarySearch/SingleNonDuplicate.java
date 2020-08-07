package com.rule.problem.interview.binarySearch;

/**
 * 540. 有序数组中的单一元素
 */
public class SingleNonDuplicate {


    /**
     * 暴力法
     */
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static int singleNonDuplicate2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        singleNonDuplicate2(new int[]{1,1,2,2,3});
    }
}
