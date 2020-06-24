package com.rule.problem.interview.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 725. 分隔链表
 */
public class SplitListToParts {

    /**
     * 等差公式：an = a1 + (n - 1)*d
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode head = root;
        while (root != null) {
            len++;
            root = root.next;
        }
        List<Integer> nums = new ArrayList<>();
        if (len >= k) {
            for (int i = 0; i < k; i++) {
                nums.add(i);
            }
        }
        int a;
        return null;
    }
}
