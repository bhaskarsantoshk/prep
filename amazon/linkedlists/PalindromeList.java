package amazon.linkedlists;

public class PalindromeList {
    public int lPalin(ListNode A) {
        if ( A == null ){
            return 1;
        }
        ListNode slow = A;
        ListNode fast = A;
        while ( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if ( fast.next != null ){
            slow = slow.next;
        }
        ListNode a = A;
        ListNode b = reverse( slow);
        while ( a != null && b!= null ){
            if ( a.val != b.val){
                return 0;
            }
            a = a.next;
            b = b.next;
        }
        return 1;
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
