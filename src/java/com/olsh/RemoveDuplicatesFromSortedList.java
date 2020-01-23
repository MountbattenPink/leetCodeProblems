package com.olsh;

import com.olsh.entities.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head, Integer value) {
        if (head == null) return head;
        if (value != null) {
            if (head.val == value.intValue()) {
                head = head.next;
                return deleteDuplicates(head, value);
            } else value = head.val;
        } else {
            value = head.val;
        }
        head.next = deleteDuplicates(head.next, value);
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        return deleteDuplicates(head, null);
    }

}
