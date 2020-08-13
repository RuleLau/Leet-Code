package com.rule.problem.interview.queue_stack;

import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-08-12 08:06
 **/
public class DailyTemperatures {
    //73 74 75 71 69 72 76 73
    // 1 1  4  2  1  1  0  0
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> pos = new ArrayDeque<>();
        int[] res = new int[len];
        Arrays.fill(res, 0);
        for (int i = 0; i < len; i++) {
            int num = T[i];
            while (!stack.isEmpty() && num > stack.peek()) {
                int pop = pos.pop();
                res[pop] = i - pop;
                stack.pop();
            }
            pos.push(i);
            stack.push(num);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}
