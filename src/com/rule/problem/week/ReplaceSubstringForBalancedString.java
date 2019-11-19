package com.rule.problem.week;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.
 * A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.
 * Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.
 * Return 0 if the string is already balanced.
 *Example 1:
 *
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * Example 2:
 *
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 * Example 3:
 *
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 * Example 4:
 *
 * Input: s = "QQQQ"
 * Output: 3
 * Explanation: We can replace the last 3 'Q' to make s = "QWER".
 *
 * @description: 1234
 * @author: rule
 * @date: 2019-10-20 17:08
 **/
public class ReplaceSubstringForBalancedString {
    /**
     * mine
     */
    public static int balancedString(String s) {
        Map<String, Integer> appearTimes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = s.charAt(i) + "";
            if (appearTimes.containsKey(key)) {
                appearTimes.put(key, appearTimes.get(key) + 1);
            }else {
                appearTimes.put(key, 1);
            }
        }
        int avgTimes = s.length() / 4;
        int total = 0;
        Iterator<Map.Entry<String, Integer>> iterator = appearTimes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if (next.getValue() > avgTimes) {
                total += (next.getValue() - avgTimes);
            }
        }
        return total == 0 ? 0 :  total;
    }

    public static void main(String[] args) {
        String s = "WWEQERQWQWWRWWERQWEQ";
        System.out.println(balancedString(s));
    }
}
