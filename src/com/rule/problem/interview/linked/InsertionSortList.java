package com.rule.problem.interview.linked;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode h = head;
        int len = 0;
        while (h != null) {
            h = h.next;
            len++;
        }
        int times = 0;
        while (node != null) {
            ListNode next = node.next;
            while (next != null && node.val > next.val && times < len) {
                pre = next;
                next = next.next;
                times++;
            }
            if (times != 0) {
                head = node.next;
            }
            pre.next = node;
            ListNode temp = node.next;
            node.next = next;
            node = temp;
            len--;
            times = 0;
        }
        return head;
    }
}
