package com.rule.problem.interview.queue_stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer integer = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return integer;
    }

    /** Get the top element. */
    public int top() {
        return queue.get(queue.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
