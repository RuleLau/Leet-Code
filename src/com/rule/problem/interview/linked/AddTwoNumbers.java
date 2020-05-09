package com.rule.problem.interview.linked;


public class AddTwoNumbers {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while (l1 != null) {
            str1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            str2.append(l2.val);
            l2 = l2.next;
        }
        long sum = Long.parseLong(str1.reverse().toString()) + Long.parseLong(str2.reverse().toString());
        if (sum == 0) {
            return new ListNode(0);
        }
        str1.setLength(0);
        str1.append(sum);
        int len = str1.length();
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
