package com.rule.problem.interview.linked;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeTwoLists {

    /**
     * 21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }

    /**
     * 23. 合并K个排序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        List<ListNode> nodes = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                nodes.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        nodes.sort((Comparator.comparingInt(o -> o.val)));
        for (int i = 0; i < nodes.size(); i++) {
            dummy.next = nodes.get(i);
            dummy = dummy.next;
        }
        return head.next;
    }
}
