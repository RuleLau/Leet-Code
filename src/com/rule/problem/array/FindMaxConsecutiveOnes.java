package com.rule.problem.array;

import java.util.*;

public class FindMaxConsecutiveOnes {

    /**
     * 485. 最大连续 1 的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int dup = -1, missing = 1;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    dup = i;
            } else
                missing = i;
        }
        return new int[]{dup, missing};

    }

    /**
     * 442. 数组中重复的数据
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

}
