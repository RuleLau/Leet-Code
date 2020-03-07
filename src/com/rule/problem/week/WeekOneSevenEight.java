package com.rule.problem.week;

import java.util.*;

public class WeekOneSevenEight {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        Map<Integer, Set<Integer>> valueIndex = new HashMap<>(len); // 预存每个值与索引对应
        for (int i = 0; i < len; i++) {
            if (!valueIndex.containsKey(nums[i])) valueIndex.put(nums[i], new HashSet<>());
            valueIndex.get(nums[i]).add(i);
        }
        int[] sortedArr = Arrays.copyOf(nums, len), res = new int[len];
        Arrays.sort(sortedArr); // 1, 2, 2, 3, 8
        for (int si = len - 1; si >= 0; si--) {
            for (int i : valueIndex.get(sortedArr[si])) res[i] = si; // 同值的所有索引都更新
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 8, 1, 1, 2}));
    }
}
