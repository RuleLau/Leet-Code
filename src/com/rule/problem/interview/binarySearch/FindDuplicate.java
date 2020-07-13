package com.rule.problem.interview.binarySearch;

/**
 * 287. 寻找重复数
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int right = nums.length - 1;
        int left = 1;
        int dup = 0;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    dup++;
                }
            }
            if (dup <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
            dup = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println((1 + 4) >> 1);
    }
}
