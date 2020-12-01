package com.rule.problem.week;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Week217
 *
 * @author liurui1
 * @version 1.0.0
 * @date 2020/11/30 14:25
 */
public class Week217 {

    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        int len = n - k + 1;
        for (int i = 0; i < n; i++) {
            //队头滑出
            if (queue.size() > 0 && (queue.peekFirst() < i - len + 1)) {
                queue.pollFirst();
            }
            //与新进来元素比较，维护单调性
            while (queue.size() > 0 && nums[queue.peekLast()] > nums[i]) {
                queue.pollLast();
            }
            //新元素入队
            queue.addLast(i);
            //更新答案
            if (i >= len - 1) {
                res[index++] = nums[queue.pollFirst()];
            }
        }
        return res;
    }

}
