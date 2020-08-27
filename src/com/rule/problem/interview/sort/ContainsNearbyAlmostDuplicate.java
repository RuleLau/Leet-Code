package com.rule.problem.interview.sort;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 */
public class ContainsNearbyAlmostDuplicate {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        int low = 0;
        TreeSet<Long> set = new TreeSet<>();
        while (low < len) {
            long cur = nums[low];
            Long s = set.ceiling(cur);
            if (s != null && Math.abs(cur - s) <= t) {
                return true;
            }
            Long ceiling = set.floor(cur);
            if (ceiling != null && Math.abs(cur - ceiling) <= t) {
                return true;
            }
            set.add(cur);
            if (set.size() > k) {
                set.remove((long) nums[low - k]);
            }
            low++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{7, 1, 3}, 2, 3));
    }
}
