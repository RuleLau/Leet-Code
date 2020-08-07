package com.rule.problem.interview.queue_stack;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private List<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new ArrayList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer integer = stack.get(0);
        stack.remove(0);
        return integer;
    }

    /** Get the front element. */
    public int peek() {
        return stack.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

}
