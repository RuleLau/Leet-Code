package com.rule.problem.matrix;

/**
 * 766. 托普利茨矩阵
 */
public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i + 1 < matrix.length && j + 1 < matrix[0].length && matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }
}
