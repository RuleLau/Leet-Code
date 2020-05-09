package com.rule.problem.interview.linked;


public class AddTwoNumbers {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //1 99
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder str1 = new StringBuilder();
        int bit = 0;
        while (l1 != null && l2 != null) {
            int s = l1.val + l2.val + bit;
            str1.append(s % 10);
            bit = s >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int s = l1.val + bit;
            str1.append(s % 10);
            bit = s >= 10 ? 1 : 0;
            l1 = l1.next;
        }
        while (l2 != null) {
            int s = l2.val + bit;
            str1.append(s % 10);
            bit = s >= 10 ? 1 : 0;
            l2 = l2.next;
        }
        if (bit != 0) {
            str1.append(bit);
        }

        StringBuilder reverse = str1.reverse();
        if (reverse.length() == 1 && "0".equals(reverse.toString())) {
            return new ListNode(0);
        }
        int len = reverse.length();
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(str1.charAt(--len))));
        ListNode res = head;
        while (len > 0) {
            int val = Integer.parseInt(String.valueOf(str1.charAt(--len)));
            head.next = new ListNode(val);
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
    }

}
