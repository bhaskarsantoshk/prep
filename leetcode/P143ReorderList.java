package leetcode;

import amazon.linkedlists.ListNode;

public class P143ReorderList {
    public void reorderList(ListNode head) {
        if ( head == null || head.next == null ){
            return;
        }
        ListNode prev = null, slow = head, fast = head, l1= head;
        while ( fast != null && fast.next != null ){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        while ( l1!= null ){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if ( n1 == null ){
                break;
            }
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        while ( cur != null ){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
