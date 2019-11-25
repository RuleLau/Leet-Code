package com.rule.problem.week;

/**
 * 164 week
 *
 * @description: 1266. Minimum Time Visiting All Points
 * @author: rule
 * @date: 2019-11-24 15:39
 **/
public class MinimumTimeVisitingPoints {

    public static int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length == 1) {
            return 0;
        }
        int times = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int width = Math.abs(points[i + 1][0] - points[i][0]);
            int height = Math.abs(points[i + 1][1] - points[i][1]);
            if (width < height) {
                times += height;
            } else {
                times += width;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        int[][] points1 = new int[][]{{3, 2}, {-2, 2}};
        int[][] points2 = new int[][]{{1, 1}, {3, 3}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
        System.out.println(minTimeToVisitAllPoints(points1));
        System.out.println(minTimeToVisitAllPoints(points2));
    }
}
