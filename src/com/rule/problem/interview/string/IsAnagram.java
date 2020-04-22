package com.rule.problem.interview.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();//关于A->B的映射
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.get(sc) == null) {//保证A中当前元素未建立映射
                if (map.containsValue(tc)) {//保证B中当前元素未建立映射
                    return false;
                }
                map.put(sc, tc);//建立A中当前元素与B中当前元素一一映射关系
            } else if (map.get(sc) != tc) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("egg", "add"));
    }
}
