package com.rule.problem.interview.linked;

/**
 * 86. 分隔链表
 */
public class Partition {

    //输入: head = 1->4->3->2->5->2, x = 3
    //输出: 1->2->2->4->3->5
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode firstMax = null;
        ListNode lastNode = null;
        while (temp != null) {
            lastNode = temp;
            temp = temp.next;
            if (head.val >= x ) {
                firstMax = temp;
            }else {

            }

        }
        if (lastNode == null) {
            return head;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        partition(l1, 3);
    }
}
