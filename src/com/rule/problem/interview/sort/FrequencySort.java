package com.rule.problem.interview.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 */
public class FrequencySort {

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxheap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        maxheap.addAll(map.entrySet());
        while (!maxheap.isEmpty()) {
            Map.Entry<Character, Integer> poll = maxheap.poll();
            Integer value = poll.getValue();
            Character key = poll.getKey();
            for (int i = 0; i < value; i++) {
                res.append(key);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }

}
