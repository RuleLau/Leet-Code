package com.rule.problem.interview.sort;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], i);
            if ((map.containsKey(nums[i] - t) && Math.abs(nums[i] - nums[i - 1]) <= t && Math.abs(map.get(nums[i - 1]) - map.get(nums[i])) <= k)) {
                return true;
            }
        }
        return false;
    }
}
