package amazon.linkedlists;

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if ( A == null ){
            return null;
        }
        ListNode fast = A;
        for ( int i=0; i<B; i++){
            if ( fast == null ){
                return A.next;
            }
            fast = fast.next;
        }
        ListNode result = new ListNode(0);
        ListNode slow = result;
        slow.next = A;
        while ( fast != null ){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }
}
