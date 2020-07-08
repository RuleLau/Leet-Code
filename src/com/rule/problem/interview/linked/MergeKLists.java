package com.rule.problem.interview.linked;

/**
 * @description:
 * @author: rule
 * @date: 2020-07-08 20:57
 **/
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 取最小的值开头的链表
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (i == 0 ) {
                min = lists[0].val;
            }

            if (min > lists[i].val) {
                minIndex = i;
                min = lists[i].val;
            }
        }

        ListNode head = lists[minIndex];
        ListNode tail = lists[minIndex];
        for (int i = 0; i < lists.length; i++) {
            if (i == minIndex || lists[i] == null) {
                continue;
            }
            ListNode temp = lists[i];
            ListNode last = tail;
            while (temp != null) {
                while (tail != null && temp.val >= tail.val) {
                    last = tail;
                    tail = tail.next;
                }
                last.next = temp;
                ListNode c = temp.next;
                temp.next = tail;
                last = temp;
                temp = c;
            }
            tail = head;
        }

        // 1 4 5 1 3 4 2 6
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{null, l2};

        mergeKLists(lists);

    }

}
