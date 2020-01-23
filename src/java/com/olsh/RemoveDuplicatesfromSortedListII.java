/**
#82. Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

*/
package com.olsh;
import com.olsh.entities.ListNode;

import java.util.HashMap;
import java.util.Map;

class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> repeatances = new HashMap<Integer, Integer>();
        ListNode node = head;
        while (node != null) {
            if (repeatances.get(node.val) == null) {
                repeatances.put(node.val, 1);
            } else {
                repeatances.put(node.val, repeatances.get(node.val) + 1);
            }
            node = node.next;
        }
        System.out.println(repeatances);
        head = deleteRepeated(repeatances, head);
        return head;
    }

    public ListNode deleteRepeated(Map<Integer, Integer> repeatances, ListNode head) {
        if (head == null) return head;
        if (repeatances.get(head.val) > 1) head = deleteRepeated(repeatances, head.next);
        else head.next = deleteRepeated(repeatances, head.next);
        return head;
    }

}
