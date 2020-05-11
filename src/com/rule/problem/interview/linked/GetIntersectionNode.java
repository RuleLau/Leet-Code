package com.rule.problem.interview.linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GetIntersectionNode {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 反转链表 headA
        ListNode node = headA;
        ListNode first = headA;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = headA;
            headA = next;
            node = first;
        }
        // 反转链表 headB
        node = headB;
        first = headB;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = headB;
            headB = next;
            node = first;
        }
        // 找到公共部分
        node = headA;
        first = headA;
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                headA = headA.next;
                headB = headB.next;
            }else {
                break;
            }
        }
        while (node != null && node.next != null && node != headA) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = headA;
            headA = next;
            node = first;
        }
        return node;
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
