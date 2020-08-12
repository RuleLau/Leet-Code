package com.rule.problem.interview.queue_stack;

import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-08-12 08:06
 **/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        Arrays.fill(res, 0);
        int j = 0;
        for (int i = 0; i < len; i++) {
            int k = 0;
            int num = T[i];
            while (!stack.isEmpty() && num > stack.peek()) {
                res[i - stack.size()] = stack.size();
                stack.pop();
            }
            stack.push(num);
        }
        return res;
    }

}
