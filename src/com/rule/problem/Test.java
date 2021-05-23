package com.rule.problem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        Test o = new Test();
        System.out.println(o.getClass().getClassLoader());
        Map<String, String> map = new HashMap<>();
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        if (len == 1) {
            return adjacentPairs[0];
        }
        int n = len + 1;
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            List<Integer> list1 = map.getOrDefault(adjacentPair[0], new ArrayList<>());
            list1.add(adjacentPair[1]);
            map.put(adjacentPair[0], list1);
            List<Integer> list2 = map.getOrDefault(adjacentPair[1], new ArrayList<>());
            list2.add(adjacentPair[0]);
            map.put(adjacentPair[1], list2);
        }
        dfs(map, ans);
        return ans;
    }

    private void dfs(Map<Integer, List<Integer>> map, int[] ans) {
        int start = 0;
        AtomicInteger a = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v.size() == 1) {
                a.set(k);
            }
        });
        int b = a.get();
        int last = b;
        while (map.size() != 0) {
            System.out.println("b = " + b);
            ans[start++] = b;
            List<Integer> list = map.get(b);
            int c = b;
            b = list.size() == 1 ? list.get(0) : list.get(0) == last ? list.get(1) : list.get(0);
            last = c;
            map.remove(c);
        }
    }
}
