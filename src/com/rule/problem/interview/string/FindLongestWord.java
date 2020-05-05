package com.rule.problem.interview.string;

import java.util.ArrayList;
import java.util.List;


public class FindLongestWord {

    public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    /**
     * 524. 通过删除字母匹配到字典里最长单词
     */
    public static String findLongestWord(String s, List<String> d) {
        String max_str = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        res.add("a");
        res.add("b");
        res.add("c");
        System.out.println(findLongestWord("abpcplea", res));
    }
}
