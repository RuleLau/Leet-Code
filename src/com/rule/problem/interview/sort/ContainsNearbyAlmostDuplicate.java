package com.rule.problem.interview.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>(nums.length));
            list.add(i);
            map.put(nums[i], list);
        }
        List<Integer> temp;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int high = Math.max(n, Math.abs(n - k));
            while (n <= high) {
                if (map.containsKey(high)) {
                    temp = map.get(high);
                    for (int j = 0; j < temp.size(); j++) {
                        if (i != temp.get(j) && Math.abs(i - temp.get(j)) <= t) {
                            return true;
                        }
                    }
                }
                high--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }
}
