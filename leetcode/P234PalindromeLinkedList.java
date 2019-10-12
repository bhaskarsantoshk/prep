package leetcode;

import amazon.linkedlists.ListNode;

public class P234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if ( head == null ) return true;
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != null && fast.next.next!= null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if ( fast.next != null ){
            slow = slow.next;
        }
        ListNode a = head;
        ListNode b = reverseList(slow);
        while ( a!= null && b!= null ){
            if ( a.val!= b.val){
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while ( cur != null ){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}
