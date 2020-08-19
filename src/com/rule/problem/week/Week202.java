package com.rule.problem.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: week202
 * @author: rule
 * @date: 2020-08-16 17:30
 **/
public class Week202 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                sum++;
            } else {
                sum = 0;
            }
            if (sum == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * 5488. 使数组中所有元素相等的最小操作数
     */
    public int minOperations(int n) {
        //1 3 5 7 9 11 13
        int mid = n / 2;
        if (n % 2 == 0) {
            return mid * mid;
        } else {
            return mid * mid + mid;
        }
    }

    /**
     * 5489. 两球之间的磁力
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int hi = (position[position.length - 1] - position[0]) / (m - 1);
        int lo = 1;
        int ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(position, mid, m)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    boolean check(int[] position, int distance, int m) {
        int count = 1;
        int i = 0;
        for (int j = 1; j < position.length; j++) {
            if (position[j] - position[i] >= distance) {
                i = j;
                count++;
                if (count >= m) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 5490. 吃掉 N 个橘子的最少天数
     */
    public int minDays(int n) {
        return getMinDay(n);

    }

    private Map<Integer, Integer> maps = new HashMap<>();

    private int getMinDay(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 2;
        }
        Integer re = maps.get(n);
        // 是否之前计算过
        if (re != null) {
            return re;
        }

        int m2 = getMinDay(n / 2) + n % 2;
        int m3 = getMinDay(n / 3) + n % 3;
        int result = Math.min(m2, m3) + 1;
        // 存储结果
        maps.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        //maxDistance(new int[]{1, 2, 3, 4, 7}, 3);
    }
}
