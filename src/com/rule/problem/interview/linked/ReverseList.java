package com.rule.problem.interview.linked;

public class ReverseList {

    /**
     * 206. 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 1 2 3 4 5
        ListNode prev = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;//3
            head.next = prev;//1
            prev = head;
            head = next;
        }
        return next;
    }
}
