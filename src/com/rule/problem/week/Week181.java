package com.rule.problem.week;

import java.util.*;

public class Week181 {

    /**
     * 1389. Create Target Array in the Given Order
     */
    public static int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] target = new int[len];
        Arrays.fill(target, Integer.MIN_VALUE);
        for (int i = 0; i < len; i++) {
            int idx = index[i];
            if (target[idx] != Integer.MIN_VALUE) {
                //移位
                for (int j = len - 1; j > idx; j--) {
                    target[j] = target[j - 1];
                }
            }
            target[idx] = nums[i];
        }
        return target;
    }

    /**
     * 1390. Four Divisors
     */
    public static int sumFourDivisors(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (findDivisors(nums[i]));
        }
        return sum;
    }

    public static int findDivisors(int num) {
        int count = 0;
        int mid = num / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < mid; i++) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
            if (set.size() > 4) {
                return 0;
            }
        }
        if (set.size() != 4) {
            return 0;
        } else {
            for (Integer i : set) {
                count += i;
            }
        }
        return count;
    }

    private enum D {up, down, left, right};
    int m, n;
    int[][] to = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 这个方向坐标操作

    public static boolean hasValidPath(int[][] grid) {
        //1 -- 除了本身和2
        //2 -- 除了本身和1
        //3, 4, 5, 6 -- 对应除本身外的所有数
        // 定义 上 0 下 1 左 2 右 3
        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(1, new Integer[]{2, 3});
        map.put(2, new Integer[]{0, 1});
        map.put(3, new Integer[]{1, 2});
        map.put(4, new Integer[]{1, 3});
        map.put(5, new Integer[]{0, 2});
        map.put(6, new Integer[]{0, 3});
        return true;
    }


    public static void main(String[] args) {
        //createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1});
        //System.out.println(sumFourDivisors(new int[]{21, 4, 7}));
    }
}
