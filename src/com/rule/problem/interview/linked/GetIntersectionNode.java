package com.rule.problem.interview.linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GetIntersectionNode {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        while (headA != null) {
            len1++;
            headA = headA.next;
        }
        while (headB != null) {
            len2++;
            headB = headB.next;
        }
        int len = Math.abs(len1 - len2);
        if (len == 0) {

        }else {

        }
        return null;
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
