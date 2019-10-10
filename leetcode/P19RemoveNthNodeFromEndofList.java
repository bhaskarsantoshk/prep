package leetcode;

import amazon.linkedlists.ListNode;

public class P19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for ( int i=0; i< n; i++){
            fast = fast.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode slow = dummyHead;
        slow.next = head;
        while ( fast != null ){
            slow = slow.next;
            fast = fast.next;
        }
        return dummyHead.next;
    }
}
