package com.rule.problem.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxChunksToSorted {

    /**
     * 769. 最多能完成排序的块
     */
    public static int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(maxChunksToSorted(new int[]{0, 1}));
    }
}
