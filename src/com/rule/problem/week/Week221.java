package com.rule.problem.week;

import java.util.ArrayList;
import java.util.List;

public class Week221 {

    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int a1 = 0;
        int b1 = 0;
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int len = chars.length / 2;
        for (int i = 0; i < chars.length / 2; i++) {
            if (list.contains(chars[i])) {
                a1++;
            }
            if (list.contains(chars[i + len])) {
                b1++;
            }
        }
        return a1 == b1;
    }

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int[] expire = new int[n];
        for (int i = 0; i < days.length; i++) {
            expire[i] = i + days[i];
        }
        int ans = 0;
        for (int i = 0; i < apples.length; i++) {
            if (apples[i] != 0) {
                if (days[i] > apples[i]) {
                    ans += apples[i];
                }else {
                    ans += days[i];
                }
            } else {

            }
        }
        return 0;
    }

}
