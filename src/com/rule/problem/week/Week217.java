package com.rule.problem.week;

import java.util.*;

/**
 * Week217
 *
 * @author liurui1
 * @version 1.0.0
 * @date 2020/11/30 14:25
 */
public class Week217 {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //当前元素比队尾元素小，将队尾元素出栈
            //此处需要另外判断数组剩余长度够不够填满栈，不然最后答案长度可能会小于k
            while (nums[i] < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(nums[i]);
            }
        }
        int[] ret = new int[k];
        while (k > 0) {
            ret[--k] = stack.pop();
        }
        return ret;
    }

    public int waysToMakeFair(int[] nums) {
        int oddSum = 0;
        int evenSum = 0;
        int ans = 0;
        int leftOddSum = 0;
        int rightOddSum = 0;
        int leftEvenSum = 0;
        int rightEvenSum = 0;
        // 奇数偶数总和
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            }else {
                oddSum += nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            }else {
                leftOddSum += nums[i];
            }
            // 右边奇数
            rightOddSum = evenSum - leftEvenSum;
            // 右边偶数
            rightEvenSum = oddSum - leftOddSum;
            int a = leftEvenSum;
            int b = leftOddSum;
            if (i % 2 == 0) {
                a = leftEvenSum - nums[i];
            }else {
                b = leftOddSum - nums[i];
            }
            if (a + rightEvenSum == b + rightOddSum) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Week217 week217 = new Week217();
        System.out.println(week217.waysToMakeFair(new int[]{2, 1, 6, 4, 5, 6}));
        System.out.println(week217.waysToMakeFair(new int[]{1,2,3}));
//        week217.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
    }
}
