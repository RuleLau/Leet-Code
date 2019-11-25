package com.rule.problem;

import java.util.*;

/**
 * @description: 15. 3Sum
 * @author: rule
 * @date: 2019-11-18 22:52
 **/
public class ThreeSum {

    /**
     * Time Limit Exceeded
     * Details
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        int i = 0, j, k;
        while (i < nums.length - 2) {
            j = i + 1;
            while (j < nums.length - 1) {
                k = j + 1;
                while (k < nums.length) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        set.add(list);
                        //System.out.println(nums[i] + "=" + nums[j] + "=" + nums[k]);
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        if (set.size() == 0) {
            return result;
        }
        set.forEach(item -> result.add(item));
        System.out.println(result);
        return result;
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{1, 1, -2};
        int[] nums2 = new int[]{3, -2, 1, 0};
        int[] nums3 = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        threeSum(nums);
        System.out.println("==========");
        threeSum(nums1);
        System.out.println("==========");
        threeSum(nums2);
        threeSum(nums3);
    }


}
