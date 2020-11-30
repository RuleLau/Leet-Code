package com.rule.problem.week;

/**
 * @description:
 * @author: rule
 * @date: 2020-10-26 09:26
 **/
public class Week212 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] chars = keysPressed.toCharArray();
        int min = releaseTimes[0];
        char minChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            int a = releaseTimes[i] - releaseTimes[i - 1];
            if (a >= min) {
                if (a > min) {
                    minChar = chars[i];
                }else if (minChar < chars[i]){
                    minChar = chars[i];
                }
                min = a;
            }
        }
        return minChar;

    }

}
