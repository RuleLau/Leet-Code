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

}
