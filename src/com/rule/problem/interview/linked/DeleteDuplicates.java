package com.rule.problem.interview.linked;

/**
 * 083. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {

    /**
     * 083. 删除排序链表中的重复元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null && head.next != null) {
            ListNode second = head.next;
            if (head.val == second.val) {
                head.next = second.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }

    /**
     * 082. 删除排序链表中的重复元素 II
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode res = node;
        while (head != null) {
            ListNode next = head.next;
            if (next == null || head.val != next.val) {
                node.next = head;
                node = node.next;
                head = head.next;
            }else {
                while (next != null && head.val == next.val) {
                    head = head.next;
                    next = head.next;
                }
                head = head.next;
                node.next = head;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates2(head);
    }
}
