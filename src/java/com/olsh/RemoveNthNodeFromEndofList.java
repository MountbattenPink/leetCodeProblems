/**
#19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 */
 
 
package com.olsh;
import com.olsh.entities.ListNode;
class RemoveNthNodeFromEndofList {
   public ListNode removeNthFromEnd(ListNode head, int n) {
    int i=0;
    ListNode c = head;
    while (c!=null){
	    c=c.next;
	    i++;
        }
    int pos = i-n;
    head=remove(head, pos, 1);
    return head;
}

    public ListNode remove(ListNode head, int pos, int currentPos){
        if (pos==currentPos-1){
            head=head.next;
        }
        else {
            head.next=remove(head.next, pos, currentPos+1);
        }
            return head;
    } 
}
