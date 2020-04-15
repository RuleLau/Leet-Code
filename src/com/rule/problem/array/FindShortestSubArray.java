package com.rule.problem.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FindShortestSubArray {
    /**
     * 697. 数组的度
     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = listMap.getOrDefault(nums[i], new ArrayList<>());
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                map.put(nums[i], value);
                max = Math.max(max, value);
            } else {
                map.put(nums[i], 1);
            }
            list.add(i);
            listMap.put(nums[i], list);
        }
        int finalMax = max;
        AtomicInteger len = new AtomicInteger(50000);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v == finalMax) {
                List<Integer> list = listMap.get(k);
                len.set(Math.min(len.get(), list.get(list.size() - 1) - list.get(0)));
            }
        }
        return len.get() == 50000 ? 1 : len.get() + 1;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1}));
    }
}
