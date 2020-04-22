package com.rule.problem.interview.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayNesting {
    /**
     * 超时
     */
    public static int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap();
            max = Math.max(max, deepTh(map, nums, i));
        }
        return max;
    }

    private static int deepTh(Map<Integer, Integer> map, int[] nums, int index) {
        int key = nums[index];
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        }else {
            map.put(key, 1);
        }
        if (map.get(key) == 2) {
            return map.size();
        }
        return deepTh(map, nums, key);
    }

    public int arrayNesting2(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{0, 1}));
    }
}
