package com.rule.problem.array;

import java.util.*;

public class FourSum {
    /**
     * 018. 四数之和
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int s = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = s + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> values = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(values);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 454. 四数相加 II
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[j];
                if (map.containsKey(sumAB)) {
                    map.put(sumAB, map.get(sumAB) + 1);
                } else {
                    map.put(sumAB, 1);
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[j]);
                if (map.containsKey(sumCD)) {
                    res += map.get(sumCD);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }
}
