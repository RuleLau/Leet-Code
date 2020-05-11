package com.rule.problem.interview.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 141. 环形链表
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head, map.getOrDefault(head, 0) + 1);
            if (map.get(head) == 2) {
                break;
            }
            head = head.next;
        }
        return head != null;
    }
}
