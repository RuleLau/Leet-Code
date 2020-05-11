package com.rule.problem.interview.linked;

public class GetIntersectionNode {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (headA != null) {
            len1++;
            headA = headA.next;
        }
        while (headB != null) {
            len2++;
            headB = headB.next;
        }
        int len = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (len != 0) {
                l1 = l1.next;
                len--;
            }
        } else {
            while (len != 0) {
                l2 = l2.next;
                len--;
            }
        }
        while (l1 != null && l2 != null && l1!= l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        getIntersectionNode(head, null);
    }
}
