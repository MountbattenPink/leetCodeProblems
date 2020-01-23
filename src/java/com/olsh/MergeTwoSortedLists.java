package com.olsh;/*
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 */

import com.olsh.entities.ListNode;

class MergeTwoSortedLists {
            public ListNode appendToResult(ListNode l, int i){
              if (l==null) l=new ListNode(i);
              else {
                  ListNode s = l;
                  while (s.next!=null) s = s.next;
                  s.next = new ListNode(i);
              }
              return l;}

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1==null) return l2;
            if (l2==null) return l1;
            ListNode result = null;
            while (l1!=null && l2!=null){
                if (l1.val<=l2.val)
                {
                    result = appendToResult(result, l1.val);
                    l1 = l1.next;
                }
                else
                    {
                    result = appendToResult(result, l2.val);
                    l2 = l2.next;
                }
            }
            if (l1==null && l2==null) return result;
            else while (l1!=null)
            {
                result = appendToResult(result, l1.val);
                l1 = l1.next;
            }
            while (l2!=null)
            {
                result = appendToResult(result, l2.val);
                l2 = l2.next;
            }
            return result;
            }

        }
