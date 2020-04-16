package com.rule.problem.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxChunksToSorted {

    /**
     * 769. 最多能完成排序的块
     */
    public static int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int max = 1;
        int k = 0;
        for (int i = 1; i < len; i++) {
            while (k < i) {
                left.add(arr[k++]);
            }
            while (k < len) {
                right.add(arr[k++]);
            }

            left.sort(Comparator.comparingInt(o -> o));
            right.sort(Comparator.comparingInt(o -> o));

            if (left.get(i - 1) <= right.get(0)) {
                max = Math.max(max, i);
            }
            left.clear();
            right.clear();
            k = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1,0,2,3,4}));
    }
}
