package com.rule.problem.week;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

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
                System.out.println(x + "=" + y);
                ans++;
            }
            if (checkUnhappy(y, x, preferences)) {
                System.out.println(x + "=" + y);
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
        // int[] temp = new int[len];
        int sum = 0;
        //temp[0] = 1;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            int x = points[i][0];
            int y = points[i][1];
            for (int j = i + 1; j < len; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int s = Math.abs(x1 - x) + Math.abs(y1 - y);
                temp[i][j] = s;
                temp[j][i] = s;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        final int[] min = {Integer.MAX_VALUE};
        final int[] index = {0};
        for (int i = 1; i < len; i++) {
            sum += findMin(temp, map, min, index);
        }
        return sum;
    }

    private int findMin(int[][] points, Map<Integer, Integer> map, int[] min, int[] index) {
        map.forEach((k, v) -> {
            int[] point = points[k];
            for (int i = 0; i < point.length; i++) {
                if (!map.containsKey(i) && min[0] > points[k][i]) {
                    min[0] = points[k][i];
                    index[0] = i;
                }
            }
        });
        map.put(index[0], 0);
        return min[0];
    }

    public int minCostConnectPointsI(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++) {//计算顶点i到其他顶点之间的费用
            for (int j = i + 1; j < n; j++) {
                edges[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        return prim(edges, 0);
    }

    public int prim(int[][] edge, int start) {//用邻接矩阵表示的无向图，从start开始prim
        int n = edge.length;//顶点个数
        int res = 0;//最小权值
        int tree_size = 1;//当前树的顶点个数
        int[] lowcost = new int[n];//lowcost[i]表示T1中的顶点i到集合T内某个顶点的最小权值
        int[] nerv = new int[n];//nerv[i]表示T1中的顶点i到集合T内的哪个顶点最近，如果i在T内，则nerv=-1

        //根据e初始化lowcost和nerv
        for (int i = 0; i < n; i++) {
            lowcost[i] = edge[start][i];
            nerv[i] = i == start ? -1 : start;
        }
        while (tree_size < n) {
            int min_dis = Integer.MAX_VALUE;
            int v = -1;
            for (int i = 0; i < n; i++) {//从T1中寻找一个顶点，使之是到T中节点的最小距离
                if (nerv[i] != -1 && lowcost[i] < min_dis) {
                    min_dis = lowcost[i];
                    v = i;
                }
            }
            if (v != -1) {
                nerv[v] = -1;
                tree_size++;
                res += min_dis;
                //由于集合T新加入了顶点v，所以要更新lowcost中顶点v与T1集合中各顶点的距离
                for (int j = 0; j < n; j++) {
                    if (nerv[j] != -1 && edge[v][j] < lowcost[j]) {
                        lowcost[j] = edge[v][j];//顶点j和刚加入的顶点v的距离更短
                        nerv[j] = v;//更换顶点j在T中的最近节点
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        week206 w = new week206();
//        System.out.println(w.unhappyFriends(4, new int[][]{
//                {1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}
//        }, new int[][]{
//                {1, 3}, {0, 2}
//        }));
        System.out.println(w.minCostConnectPointsI(new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
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
