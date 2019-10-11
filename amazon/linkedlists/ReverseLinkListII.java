package amazon.linkedlists;

public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if ( A == null ) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode pre = dummy;
        for ( int i=0; i<B-1; i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;

        for ( int i=0; i< C-B; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
