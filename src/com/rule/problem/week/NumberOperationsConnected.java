package com.rule.problem.week;

/**
 *
 * @description 1319. Number of Operations to Make Network Connected
 * @author liurui-1
 * @date 2020/1/15 17:48
 * @version 1.0.0
 */
public class NumberOperationsConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = n;
        for (int[] connection : connections) {
            int p1 = findParent(parent, connection[0]);
            int p2 = findParent(parent, connection[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                components--;
            }
        }
        return components - 1;
    }

    private int findParent(int[] parent, int i) {
        if (i == parent[i]) {
            return i;
        }
        parent[i] = findParent(parent, parent[i]);
        return parent[i];
    }
}
