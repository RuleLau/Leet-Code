package com.rule.problem.interview.linked;

import java.util.Stack;

/**
 * 445. 两数相加 II
 */
public class AddTwoNumbers2 {

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
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        int bit = 0;
        System.out.println("l1 : " + str1);
        System.out.println("l2 : " + str2);
        StringBuilder str3 = new StringBuilder();
        int sum;
        while (len1 >= 0 && len2 >= 0) {
            sum = Integer.parseInt(String.valueOf(str1.charAt(len1)))
                    + Integer.parseInt(String.valueOf(str2.charAt(len2)))
                    + bit;
            bit = sum >= 10 ? 1 : 0;
            str3.append(sum % 10);
            len1--;
            len2--;
        }
        System.out.println("len1 = len2: " + str3);
        while (len1 >= 0) {
            sum = Integer.parseInt(String.valueOf(str1.charAt(len1))) + bit;
            bit = sum >= 10 ? 1 : 0;
            str3.append(sum % 10);
            len1--;
        }
        System.out.println("len1: " + str3);
        while (len2 >= 0) {
            sum = Integer.parseInt(String.valueOf(str2.charAt(len2))) + bit;
            bit = sum >= 10 ? 1 : 0;
            str3.append(sum % 10);
            len2--;
        }
        System.out.println("len2: " + str3);
        if (bit != 0) {
            str3.append(bit);
        }
        System.out.println(str3);
        str1.setLength(0);
        str2.setLength(0);
        str3.reverse();
        ListNode head = new ListNode(0);
        ListNode res = head;
        int len3 = str3.length();
        int idx = 0;
        while (idx < len3) {
            head.next = new ListNode(Integer.parseInt(String.valueOf(str3.charAt(idx++))));
            head = head.next;
        }
        return res.next;
    }

    // 逆序输出想到用栈
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}
