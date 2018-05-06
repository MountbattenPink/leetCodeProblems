package com.olsh;

import com.olsh.entities.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoDigits(null, l1, l2, false);

    }

    public ListNode addTwoDigits(ListNode res, ListNode l1, ListNode l2, boolean plusOne) {
        if (l1 == null && l2 == null) {
            if (plusOne) res = new ListNode(1);
            return res;
        } else if (l1 == null) l1 = new ListNode(0);
        else if (l2 == null) l2 = new ListNode(0);
        int i = l1.val + l2.val;
        if (plusOne) i++;
        if (i > 9) {
            res = new ListNode(i - 10);
            res.next = addTwoDigits(res.next, l1.next, l2.next, true);
        } else {
            res = new ListNode(i);
            res.next = addTwoDigits(res.next, l1.next, l2.next, false);
        }
        return res;
    }
}
