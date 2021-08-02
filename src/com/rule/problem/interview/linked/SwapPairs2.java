package com.rule.problem.interview.linked;

import com.sun.org.apache.xpath.internal.operations.Or;

public class SwapPairs2 {

    /**
     * 24. 两两交换链表中的节点
     * 4 个变量
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        // 1 2 3 4
        // 2 1 4 3
        ListNode prev = head;
        ListNode next;
        ListNode s = null;
        // 2 1 3 4 head = 3
        while (head != null && head.next != null) {
            next = head.next;//2
            ListNode temp = next.next;//3
            next.next = head;//1
            head.next = temp;//3
            // 2 , 1, 3, 4
            if (prev == head) {
                prev = next;
            }
            if (s != null) {
                s.next = next;
            }
            // 1
            s = head;
            head = head.next;
        }
        return prev;
    }
}
