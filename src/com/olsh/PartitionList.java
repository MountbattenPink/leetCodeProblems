/*
#86. Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

*/
package com.olsh;
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode headCopy=head;
        ListNode h=null;
        ListNode t=null;
        while (headCopy!=null){
            ListNode l = new ListNode(headCopy.val);
            if (l.val<x){
                l.next = h;
                h=l;
            }
            else {
                l.next = t;
                t=l;
            }
            headCopy=headCopy.next;
        }
        head=null;
        while (t!=null){
            ListNode l = new ListNode(t.val);
            l.next=head;
            head = l;
            t=t.next;
        }
        while (h!=null){
            ListNode l = new ListNode(h.val);
            l.next=head;
            head = l;
            h=h.next;
        }
        return head;
    }
}
