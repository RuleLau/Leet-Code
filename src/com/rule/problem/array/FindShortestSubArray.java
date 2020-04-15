package com.rule.problem.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindShortestSubArray {
    /**
     *  697. 数组的度
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                map.put(nums[i], value);
                max = Math.max(max, value);
                List<Integer> list = listMap.get(max);
                list.add(nums[i]);
                listMap.put(max, list);
            }else {
                map.put(nums[i], 1);
            }
        }





        return 0;
    }
}
