package com.rule.problem.interview.queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // S = "ADOBECODEBANC", T = "ABC"
        int left = 0;
        int right = 0;
        String res = "";
        int min = Integer.MAX_VALUE;
        while (right < sLen) {
            char rChar = s.charAt(right);
            sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);
            while (left <= right && checkAll(sMap, tMap)) {
                String substring = s.substring(left, right + 1);
                if (min > substring.length()) {
                    res = substring;
                    min = res.length();
                }
                char lChar = s.charAt(left);
                int lt = sMap.get(lChar);
                if (lt == 1) {
                    sMap.remove(lChar);
                }else {
                    sMap.put(lChar, lt - 1);
                }
                left++;
            }
            right++;
        }
        return res;
    }

    private static boolean checkAll(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (sMap.size() < tMap.size()) {
            return false;
        }
        Set<Map.Entry<Character, Integer>> entries = tMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            char key = entry.getKey();
            int s = sMap.getOrDefault(key, 0);
            if (s < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}
