package com.rule.problem.interview.linked;

/**
 * 725. 分隔链表
 */
public class SplitListToParts {

    /**
     *
     * @param root
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] res = new ListNode[k];
        ListNode head = root;
        ListNode tail = root;
        int total = 0;
        while (root != null) {
            total++;
            root = root.next;
        }
        int div = total / k;
        int remainder = total % k;
       // System.out.println("div = " + div + "--- remainder = " + remainder);
        for (int i = 0; i < k; i++) {
            int num = remainder-- > 0 ? div + 1 : div;
            ListNode last = tail;
            while (num-- > 0 && tail != null) {
                last = tail;
                tail = tail.next;
            }
            res[i] = head;
            head = tail;
            if (last != null) {
                last.next = null;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        splitListToParts(l1, 5);
    }

}
