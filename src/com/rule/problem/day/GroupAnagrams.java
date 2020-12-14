package com.rule.problem.day;

import java.util.*;

public class  GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = Arrays.toString(chars);
            List<String> list = map.getOrDefault(str, new ArrayList<>());
            if (list.isEmpty()) {
                ans.add(list);
            }
            list.add(s);
            map.put(str, list);
        }
        return ans;
    }
}
