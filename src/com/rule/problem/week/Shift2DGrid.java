package com.rule.problem.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 1260. Shift 2D Grid
 * @author: rule
 * @date: 2019-11-17 12:20
 **/
public class Shift2DGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int index = 0;
        int[][] tempCopy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 当前位置
                index = i * col + j;
                // 移动后的位置
                int m = (index + k) % (row * col);
                tempCopy[m / col][m % col] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < tempCopy.length; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < tempCopy[i].length; j++) {
                rowList.add(tempCopy[i][j]);
                System.out.print(tempCopy[i][j] + "");
            }
            System.out.println();
            result.add(rowList);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] grid1 = new int[][]{{3,8,1,9}, {19,7,2,5}, {4,6,11,10}, {12,0,21,13}};
        int[][] grid2 = new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        int k = 1;
        int k1 = 4;
        int k2 = 9;
        shiftGrid(grid, k);
        System.out.println("====================");
        shiftGrid(grid1, k1);
        System.out.println("====================");
        shiftGrid(grid, k2);
        System.out.println("====================");
        shiftGrid(grid2, 3);
    }
}
