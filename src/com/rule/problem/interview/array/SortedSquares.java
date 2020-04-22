package com.rule.problem.interview.array;


import java.util.Arrays;

public class SortedSquares {

    public static int[] sortedSquares(int[] A) {

        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int b = A[i] * A[i];
            B[i] = b;
        }
        Arrays.sort(B);
        return B;
    }
}
