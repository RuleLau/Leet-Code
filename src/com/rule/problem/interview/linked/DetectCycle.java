package com.rule.problem.interview.linked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                break;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }
}
