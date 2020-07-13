package com.rule.problem.interview.linked;

/**
 * 86. 分隔链表
 */
public class Partition {

    //输入: head = 1->4->3->2->5->2, x = 3
    //输出: 1->2->2->4->3->5
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode lastMax = null;
        ListNode firstMax = null;
        ListNode lastNode = null;
        ListNode current;
        int flag = 0;
        while (temp != null) {
            current = temp;
            if (current.val >= x) {
               if (flag == 0) {
                   firstMax = current;
                   lastNode = firstMax;
                   flag = 1;
               }else {
                   lastNode = current;
               }
            } else {
                if (flag == 1) {
                    ListNode next = current.next;
                    lastNode.next = next;
                    lastMax.next = current;
                    current.next = firstMax;
                    lastMax = current;
                }else {
                    lastMax = current;
                }
            }
            temp = temp.next;
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
