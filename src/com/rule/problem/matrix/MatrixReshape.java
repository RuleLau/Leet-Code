package com.rule.problem.matrix;

/**
 * 566. 重塑矩阵
 */
public class MatrixReshape {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int a = 0;
        int b = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (b == c) {
                    a++;
                    b = 0;
                }
                res[a][b++] = nums[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4);
    }
}
