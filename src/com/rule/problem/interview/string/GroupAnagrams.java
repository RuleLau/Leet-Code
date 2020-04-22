package com.rule.problem.interview.string;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            List<String> strings = map.get(s);
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(str);
            map.put(s, strings);
        }
        map.forEach((k,v) -> {
            res.add(v);
        });
        return res;
    }
}
