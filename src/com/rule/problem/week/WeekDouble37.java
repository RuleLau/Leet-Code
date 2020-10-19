package com.rule.problem.week;


import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-10-19 13:49
 **/
public class WeekDouble37 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int len = towers.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 赋初值
        int maxSum = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            map.put(i, towers[i][2]);
            if (maxSum <= towers[i][2]) {
                maxSum = Math.max(maxSum, towers[i][2]);
                index = i;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = map.get(i);
                double distance = getDistance(towers[i], towers[j]);
                if (distance <= radius * radius) {
                    int b = map.get(j);
                    double s = 1 + Math.sqrt(distance);
                    map.put(i, a + (int) (towers[j][2] / s));
                    map.put(j, b + (int) (towers[i][2] / s));
                }
            }
            if (maxSum <= map.get(i)) {
                if (maxSum == map.get(i)) {
                    if (towers[index][0] == towers[i][0]) {
                        index = towers[index][1] < towers[i][1] ? index : i;
                    }else {
                        index = towers[index][0] < towers[i][0] ? index : i;
                    }
                }else {
                    maxSum = map.get(i);
                    index = i;
                }
            }
        }

        return new int[]{towers[index][0], towers[index][1]};
    }

    /**
     * 1621. 大小为 K 的不重叠线段的数目
     */
    public int numberOfSets(int n, int k) {
        int v = (int) (10e9 + 7);
        long ans = 0;

        return (int) (ans % v);
    }


    public double getDistance(int[] a, int[] b) {
        return (b[1] - a[1]) * (b[1] - a[1]) + (b[0] - a[0]) * (b[0] - a[0]);
    }


    public static void main(String[] args) {
        WeekDouble37 weekDouble37 = new WeekDouble37();
//        weekDouble36.bestCoordinate(new int[][]{{26, 17, 17}, {0, 20, 34}, {12, 14, 30}, {46, 50, 39}, {33, 9, 16}, {46, 20, 13},{11, 22, 37}}, 43);
//        weekDouble36.bestCoordinate1(new int[][]{{1, 2, 13}, {2, 1, 7}, {0, 1, 9}}, 2);
        weekDouble37.bestCoordinate(new int[][]{{44, 31, 4}, {47, 44, 28}, {7, 13, 0}, {13, 21, 20}, {50, 34, 18}, {47, 27, 27}}, 13);
//        weekDouble36.bestCoordinate(new int[][]{{44, 31, 4}, {47, 27, 27}, {7, 13, 0}, {13, 21, 20}, {50, 34, 18}, {47, 44, 28}}, 13);
//        System.out.println((int)4.6);

    }
}
