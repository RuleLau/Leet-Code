package com.rule.problem.interview.hash;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 217. 存在重复元素
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

    /**
     * 219. 存在重复元素 II
     */
    public static boolean containsNearbyDuplicateII(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> value = map.getOrDefault(nums[i], new ArrayList<>());
            value.add(i);
            map.put(nums[i], value);
            if (value.size() == 2) {
                if (value.get(1) - value.get(0) <= k) {
                    return true;
                } else {
                    value.remove(0);
                }
            }
        }
        return false;
    }

    /**
     * 220. 存在重复元素 III
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {


        return false;
    }

    public static void main(String[] args) {
        containsNearbyDuplicateII(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }
}
