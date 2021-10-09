package com.rule.problem.algorithm.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringClass {

    /**
     * UVA455
     *
     * @param s
     */
    public static void minZhouqi(String s) {
        //abcabcabcabc 12
        int len = s.length();
        int ans = len;
        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {
            if (len % i == 0) {
                int j;
                for (j = 0; j + i < len; j++) {
                    if (chars[j] != chars[j + i]) {
                        break;
                    }
                }
                if (j + i == len) {
                    ans = i;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static void minStrI(String s) {
        String min = s;
        int len = s.length();
        s += s;
        for (int i = 1; i < len; i++) {
            String temp = s.substring(i, i + len);
            if (temp.compareTo(min) < 0) {
                min = temp;
            }
        }
        System.out.println(min);
    }

    public static void minStrII(String s) {

    }
    // ABABC
    // ABABC
    public static int[] getNext(char[] chars) {
        int len = chars.length;
        int[] next = new int[len];
        next[0] = -1;
        int j = -1;
        int i = 0;
        while (i < len - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * P3375
     *
     * @param ts
     * @param ps
     */
    public static void kmp(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(p);

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }

        if (j == p.length) {
            System.out.println(i - j);
        } else {
            System.out.println(-1);
        }

    }

    /**
     * UVA401
     *
     * @param str
     */
    public static void huiwen(String str) {
        int length = str.length();
        int left = 0;
        int right = length - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                break;
            } else {
                left++;
                right--;
            }
        }
        if (left >= right) {
            System.out.println(str + " 是回文串");
        } else {
            System.out.println(str + " 不是回文串");
        }
    }

    /**
     * UVA642
     *
     * @param strs
     * @param temps
     */
    public static void wordAmalgamation(List<String> strs, List<String> temps) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(str);
            map.put(key, strings);
        }

        for (String temp : temps) {
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            List<String> strings = map.get(new String(chars));
            if (strings == null) {
                System.out.println("NOT A VALID WORD");
            } else {
                for (String string : strings) {
                    System.out.println(string);
                }
            }
            System.out.println("******");
        }
    }

    public static void main(String[] args) {
//        minZhouqi("abcdabcdabcdabcd");
/*        minZhouqi("HoHoHo");
        minStrI("CTCC");
        minStrI("CGAGTCAGCT");*/

        huiwen("ABABA");
        huiwen("ISAPALINILAPASI");
        huiwen("ATOYOTA");

/*        List<String> strs = new ArrayList<>();
        List<String> temps = new ArrayList<>();
        strs.add("tarp");
        strs.add("given");
        strs.add("score");
        strs.add("refund");
        strs.add("only");
        strs.add("trap");
        strs.add("work");
        strs.add("earn");
        strs.add("course");
        strs.add("pepper");
        strs.add("part");

        temps.add("resco");
        temps.add("nfudre");
        temps.add("aptr");
        temps.add("sett");
        temps.add("oresuc");

        wordAmalgamation(strs, temps);*/

        kmp("ABABCDEABABCD", "ABABCD");
    }

}
