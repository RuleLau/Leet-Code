package com.rule.problem.week;

/**
 * 164 week
 * @description: 1267. Count Servers that Communicate
 * @author: rule
 * @date: 2019-11-24 16:35
 **/
public class CountServersCommunicate {
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int flag = 0;
                    for (int k = 0; k < n; k++) {
                        if (k == j) {
                            continue;
                        }
                        if (grid[i][k] == 1){
                            count++;
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {
                        continue;
                    }
                    for (int k = 0; k < m; k++) {
                        if (k == i) {
                            continue;
                        }
                        if (grid[k][j] == 1){
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        int[][] grid1 = new int[][]{{1, 0}, {1, 1}};
        int[][] grid2 = new int[][]{{1, 1, 0,0}, {0, 0,1,0}, {0,0,1,0}, {0,0,0,1}};
        int[][] grid3 = new int[][]{{1, 0, 0,1,0}, {0, 0,0,0,0}, {0,0,0,1,0}};
        System.out.println(countServers(grid));
        System.out.println(countServers(grid1));
        System.out.println(countServers(grid2));
        System.out.println(countServers(grid3));
    }
}
