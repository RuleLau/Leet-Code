package com.rule.problem.sort;

import java.util.Arrays;

public class SortAlgorithm {

    /**
     * 快速排序
     *
     * @param arr   数组
     * @param left  l
     * @param right r
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int num = arr[left];
        int low = left;
        int high = right;
        while (low < high) {
            while (low < high && arr[high] > num) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < num) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = num;
        quickSort(arr, left, low);
        quickSort(arr, low + 1, right);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{0, 1, 6, 9, 2, 5, 3, 7, 4, 8};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        double a = .5;
        System.out.println(((a - 0.005 - a)+""));
    }

}
