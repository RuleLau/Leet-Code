package com.rule.problem.interview.queue_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        while (right < sLen) {
            char rc = s.charAt(right);
            sMap.put(rc, sMap.getOrDefault(rc, 0) + 1);
            if (check(sMap, pMap)) {
                res.add(left);
            }
            if (right - left == pLen - 1) {
                char lc = s.charAt(left);
                int l = sMap.get(lc);
                if (l == 1) {
                    sMap.remove(lc);
                }else {
                    sMap.put(lc, l - 1);
                }
                left++;
            }
            right++;
        }
        return res;
    }

    private boolean check(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        if (sMap.size() != pMap.size()) {
            return false;
        }
        Set<Map.Entry<Character, Integer>> entries = pMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            char key = entry.getKey();
            int s = sMap.getOrDefault(key, 0);
            if (s != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
    }
}
