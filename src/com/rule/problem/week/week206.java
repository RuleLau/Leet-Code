package com.rule.problem.week;

public class week206 {

    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && check(i, j, mat)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        int p = pairs.length;
        // 计算每个分组
        for (int i = 0; i < p; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            if (checkUnhappy(x, y, preferences)) {
                System.out.println(x +"="+ y);
                ans++;
            }
            if (checkUnhappy(y, x, preferences)) {
                System.out.println(x +"="+ y);
                ans++;
            }
        }
        return ans;
    }

    private boolean checkUnhappy(int x, int y, int[][] preferences) {
        int[] group = preferences[x];
        for (int i = 0; i < group.length; i++) {
            if (preferences[x][i] != y) {
                int pb = 0;
                int pc = 0;
                int c = group[i];
                int[] temp = preferences[c];
                for (int k = 0; k < temp.length; k++) {
                    if (preferences[c][k] == x) {
                        pb = k;
                    }
                    if (preferences[c][k] != x && preferences[c][k] != y) {
                        pc = k;
                    }
                    if (pb < pc) {
                        return true;
                    }
                }
            }
        }
        return true;
    }

    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[] temp = new int[len];
        int sum = 0;
        temp[0] = 1;
        for (int i = 1; temp[i] == 0; i++) {
            int x = points[i][0];
            int y = points[i][1];

        }
        for (int i = 1; i < len && temp[i] == 0; i++) {



        }


        return sum;
    }

    public static void main(String[] args) {
        week206 w = new week206();
        System.out.println(w.unhappyFriends(4, new int[][]{
                {1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}
        }, new int[][]{
                {1, 3}, {0, 2}
        }));
    }




    private boolean check(int i, int j, int[][] mat) {
        int row = mat.length - 1;
        int col = mat[0].length - 1;
        while (col >= 0) {
            if (col != j && mat[i][col] == 1) {
                return false;
            }
            col--;
        }
        while (row >= 0) {
            if (row != i && mat[row][j] == 1) {
                return false;
            }
            row--;
        }
        return true;
    }
}
