package com.rule.problem.algorithm.stack_queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayClass {

    /**
     * 彩票摇奖 P2550
     */
    public static void caiPiaoYaojiang(int[] target, int[][] nums) {
        int[] m = new int[35];
        for (int i : target) {
            m[i] = 1;
        }
        int[] sum = new int[7];
        int cnt = 0;
        for (int[] num : nums) {
            for (int i : num) {
                if (m[i] == 1) {
                    cnt++;
                }
            }
            sum[cnt]++;
            cnt = 0;
        }
        System.out.println(Arrays.toString(sum));
    }

    /**
     * 压缩技术（续集版） P1320
     *
     * @param arr
     */
    public static void press(int[][] arr) {
        StringBuilder str = new StringBuilder();
        int length = arr.length;
        System.out.print("结果长度：" + length);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                str.append(anInt);
            }
        }
        String s = str.toString();
        int cnt = 0;
        char[] chars = s.toCharArray();
        int flag = 1;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '0') {
                if (flag == 2) {
                    System.out.print(cnt);
                    flag = 1;
                    cnt = 0;
                }
                cnt++;
            } else if (aChar == '1') {
                if (flag == 1) {
                    System.out.print(cnt);
                    flag = 2;
                    cnt = 0;
                }
                cnt++;
            }

            if (i == chars.length - 1) {
                System.out.print(cnt);
            }
        }

    }

    /**
     * P1830 轰炸III
     * 10 10 2 3
     * 1 1 5 5
     * 5 5 10 10
     * 3 2
     * 5 5
     * 7 1
     */
    public static void hongzha(int m, int n, int[][] xa, int[][] ya) {
        int x = xa.length;
        int y = ya.length;
        int[] last = new int[y];
        int[] sum = new int[y];
        for (int i = 0; i < x; i++) {
            int[] b = xa[i];
            int x1 = b[0];
            int y1 = b[1];
            int x2 = b[2];
            int y2 = b[3];
            for (int j = 0; j < y; j++) {
                int c = ya[j][0];
                int d = ya[j][1];
                if (c >= x1 && c <= x2 && d >= y1 && d <= y2) {
                    last[j] = i;
                    sum[j]++;
                }
            }
        }
        for (int i = 0; i < y; i++) {
            if (sum[i] == 0) {
                System.out.println("N");
            } else {
                System.out.println("Y " + sum[i] + " " + (last[i] + 1));
            }
        }


    }

    /**
     * P1789 【Mc生存】插火把
     */
    public static void chahuoba(int n, int m, int k, int x, int y) {
        int[][] arr = new int[n][n];
        int a = x - 1;
        int b = y - 1;
        // m个火把，n个莹石
        light(arr, k, a, b);
        if (m == 1) {
            arr[Math.max(a - 2, 0)][b] = 1;
            arr[Math.min(a + 2, n - 1)][b] = 1;
            arr[a][Math.max(0, b - 2)] = 1;
            arr[a][Math.min(n - 1, b + 2)] = 1;
        }
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    sum++;
                }
            }
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(sum);
    }

    private static void light(int[][] arr, int k, int x, int y) {
        int n = arr.length;
        for (int i = Math.max(x - 1 - k, 0); i <= Math.min(x + 1 + k, n - 1); i++) {
            for (int j = Math.max(y - 1 - k, 0); j <= Math.min(y + 1 + k, n - 1); j++) {
                arr[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
  /*      caiPiaoYaojiang(new int[]{23, 31, 1,14, 19, 17, 18},
                new int[][]{
                        {12, 8, 9, 23, 1, 16, 7}, {11, 7, 10, 21, 2, 9, 31}
                });*/
/*
        press(new int[][]{
                {0,0,0,1,0,0,0}, {0,0,0,1,0,0,0}, {0,0,0,1,1,1,1}, {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0}, {0,0,0,1,0,0,0}, {1,1,1,1,1,1,1}
        });
*/
/*        hongzha(10, 10, new int[][]{{1, 1, 5, 5}, {5, 5, 10, 10}},
                new int[][]{{3, 2}, {5, 5}, {7, 1}});*/

//        chahuoba(5, 1, 0, 3, 3);
        chahuoba(5, 0, 1, 3, 3);
    }
}
