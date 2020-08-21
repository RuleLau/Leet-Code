package com.rule.problem.interview.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> collect = entries.stream().collect(Collectors.toList());
        Collections.sort(collect, (o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < k; i++) {
            res[i] = collect.get(i).getKey();
        }
        return res;
    }

    public static int[] topKFrequentII(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            maxheap.offer(m);
        }
        for(int i = 0; i < k; i++){
            result[i] = maxheap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }

}
