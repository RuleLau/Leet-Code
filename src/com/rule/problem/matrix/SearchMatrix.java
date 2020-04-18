package com.rule.problem.matrix;

/**
 * 074. 搜索二维矩阵
 */
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int a = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) {
                break;
            }else {
                a = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[a][i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 240. 搜索二维矩阵 II
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int value = matrix[i][j];
                if (value < target) {
                    break;
                }else if (value == target){
                    return true;
                }
            }
        }
        return false;
    }

}
