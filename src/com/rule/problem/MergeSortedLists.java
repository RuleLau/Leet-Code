package com.rule.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 23. Merge k Sorted Lists
 * @author: rule
 * @date: 2019-11-30 14:13
 **/
public class MergeSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
               numList.add(lists[i].val);
               lists[i] = lists[i].next;
            }
        }
        Collections.sort(numList);
        ListNode temp = result;
        for (int i = 0; i < numList.size(); i++) {
            temp.next = new ListNode(numList.get(i));
            temp = temp.next;
        }
        return result.next;
    }
}
