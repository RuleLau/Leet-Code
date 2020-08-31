package com.rule.problem.week;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: rule
 * @date: 2020-08-30 10:25
 **/
public class Week204 {

    /**
     *
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        int sum = m * k;
        StringBuilder str = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = arr.length - sum == 0 ? 1 : arr.length - sum;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < i + m; j++) {
                str.append(arr[j]);
            }
            String s = str.toString();
            for (int j = 1; j < k; j++) {
                str.append(s);
            }
            for (int j = i; j < i + sum; j++) {
                temp.append(arr[j]);
            }
            if (str.toString().equals(temp.toString())) {
                return true;
            }
            str.setLength(0);
            temp.setLength(0);
        }

        return false;
    }

    /**
     * 5500. 乘积为正数的最长子数组长度
     */
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        // 初始化值，会溢出
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                nums[i] = -1;
            } else if (nums[i] > 0) {
                nums[i] = 1;
            }
        }
        int cnt = 0;
        int max = 0;
        int sum = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                max = Math.max(cnt, max);
                if (sum < 0) {
                    while (!stack.isEmpty()) {
                        int dis = i - stack.pop();
                        max = Math.max(Math.max(cnt - dis, dis - 1), max);
                    }
                }else {
                    stack.clear();

                }
                sum = 1;
                cnt = 0;
                continue;
            } else if (nums[i] < 0) {
                stack.push(i);
            }
            sum *= nums[i];
            cnt++;
        }
        if (sum < 0) {
            while (!stack.isEmpty()) {
                int dis = len - stack.pop();
                max = Math.max(Math.max(cnt - dis, dis - 1), max);
            }
        }else {
            max = Math.max(max, cnt);
        }
        return max;
    }

    public int minDays(int[][] grid) {
        int days = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 检查是否
                }

            }
        }
        return days;
    }


    public static void main(String[] args) {
        Week204 w = new Week204();
        //w.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3);
        w.getMaxLen(new int[]{0, 1, -2, -3, -4});
    }
}
