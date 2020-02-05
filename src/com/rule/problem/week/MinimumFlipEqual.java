package com.rule.problem.week;

/**
 *
 * @description 1318. Minimum Flips to Make a OR b Equal to c
 * @author liurui-1
 * @date 2020/1/15 15:50
 * @version 1.0.0
 */
public class MinimumFlipEqual {

    public static int minFlips(int a, int b, int c) {
        String aa = Integer.toBinaryString(a);
        String bb = Integer.toBinaryString(b);
        String cc = Integer.toBinaryString(c);
        int steps = 0;
        int aLen = aa.length() - 1;
        int bLen = bb.length() - 1;
        int cLen = cc.length() - 1;
        while (cLen >= 0 && aLen >= 0 && bLen >= 0) {
            int a1 = aa.charAt(aLen) - '0';
            int b1 = bb.charAt(bLen) - '0';
            int c1 = cc.charAt(cLen) - '0';
            if (((a1 | b1) != c1)) {
                steps = a1 == b1 && a1 == 1 ? steps + 2 : steps + 1;
            }
            aLen--;
            bLen--;
            cLen--;
        }

        while (cLen >= 0) {
            int c1 = cc.charAt(cLen) - '0';
            if (aLen >= 0) {
                int a1 = aa.charAt(aLen) - '0';
                steps = (a1 | 0) == c1 ? steps : steps + 1;
                aLen--;
            }else if (bLen >= 0){
                int b1 = bb.charAt(bLen) - '0';
                steps = (b1 | 0) == c1 ? steps : steps + 1;
                bLen--;
            }else if (c1 == 1){
                steps++;
            }
            cLen--;
        }

        while (aLen >= 0) {
            int a1 = aa.charAt(aLen) - '0';
            if (bLen >= 0){
                int b1 = bb.charAt(bLen) - '0';
                if (a1 == b1 && a1 == 1) {
                    steps += 2;
                }else if (a1 == 1 || b1 == 1){
                    steps ++;
                }
                bLen--;
            }else {
                steps = a1 == 0 ? steps : steps + 1;
            }
            aLen--;
        }
        while (bLen >= 0) {
            int b1 = bb.charAt(bLen) - '0';
            if (aLen >= 0){
                int a1 = aa.charAt(aLen) - '0';
                if (a1 == b1 && a1 == 1) {
                    steps += 2;
                }else if (a1 == 1 || b1 == 1){
                    steps ++;
                }
                aLen--;
            }else {
                steps = b1 == 0 ? steps : steps + 1;
            }
            bLen--;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(10, 9, 1));
        System.out.println(minFlips(5, 2, 8));
        System.out.println(minFlips(1, 2, 3));
    }
}
