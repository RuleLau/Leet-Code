package com.rule.problem.week;

import javax.jnlp.ClipboardService;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 第 33 场双周赛
 * @author: rule
 * @date: 2020-08-28 11:39
 **/
public class WeekDouble33 {

    public static String thousandSeparator(int n) {
        if (n <= 999 && n >= 0) {
            return String.valueOf(n);
        }
        boolean flag = n < 0;
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        n = Math.abs(n);
        while (n != 0) {
            cnt++;
            int m = n % 10;
            ans.append(m);
            n = n / 10;
            if (cnt == 3) {
                ans.append(".");
                cnt = 0;
            }
        }
        if (ans.lastIndexOf(".") == ans.length() - 1) {
            ans.deleteCharAt(ans.length() - 1);
        }
        if (flag) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }

    /**
     * 1557. 可以到达所有点的最少点数目
     */
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] ans = new int[n];
        List<Integer> res = new ArrayList<>(n);
        Arrays.fill(ans, -1);
        for (List<Integer> edge : edges) {
            int end = edge.get(1);
            ans[end] = 1;
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1) {
                res.add(i);
            }
        }
        return res;
    }


    /**
     * 1558. 得到目标数组的最少函数调用次数
     */
    public static int minOperations(int[] nums) {
        int cnt = 0;
        boolean flag;
        boolean allDouble;
        do {
            flag = true;
            allDouble = true;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num != 0 && num != 1) {
                    if (num % 2 != 0) {
                        nums[i] = num - 1;
                        allDouble = false;
                        cnt++;
                    }
                    flag = false;
                } else if (nums[i] == 1) {
                    // 初始值为1的置为0
                    nums[i] = 0;
                    cnt++;
                }
            }
            if (!flag && allDouble) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] / 2;
                }
                cnt++;
            }
        } while (!flag);

        return cnt;
    }


    private int row;

    private int col;

    private int[][] isVisited = new int[500][500];

    private int[][] dd = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    /**
     * 1559. 二维网格图中探测环
     */
    public boolean containsCycle(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isVisited[i][j] == 0 && dfs(grid, i, j, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int dx, int dy, int px, int py) {
        if (isVisited[dx][dy] == 1) {
            return true;
        }
        char c = grid[dx][dy];
        isVisited[dx][dy] = 1;
        for (int[] d : dd) {
            int nx = dx + d[0];
            int ny = dy + d[1];
            if (nx == px && ny == py) {
                continue;
            }
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == c) {
                if (dfs(grid, nx, ny, dx, dy)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        //System.out.println(thousandSeparator(999));
        // minOperations(new int[]{2, 2});
        WeekDouble33 w = new WeekDouble33();
        System.out.println(w.containsCycle(new char[][]{
                {'a', 'a', 'a', 'b'}, {'a', 'b', 'c', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}
        }));
    }
}
