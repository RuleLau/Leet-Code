package com.rule.problem.interview.queue_stack;

import java.util.*;

/**
 * @description: 496. 下一个 更大元素1
 * 503. 下一个更大元素 II
 * @author: rule
 * @date: 2020-08-08 22:10
 **/
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        Map<Integer, Integer> map = new HashMap();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            map.put(num, -1);
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);

        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    /**
     * 503. 下一个更大元素 II
     */
    public static int[] nextGreaterElementII(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        //Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        System.out.println(Arrays.toString(nextGreaterElementII(new int[]{1, 3, 5, 2, 1})));
    }
}
