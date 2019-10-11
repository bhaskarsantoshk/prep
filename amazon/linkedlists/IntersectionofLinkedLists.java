package amazon.linkedlists;

public class IntersectionofLinkedLists {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if ( a == null || b == null ){
            return null;
        }
        ListNode headA = a;
        ListNode headB = b;
        while ( headA != headB ){
            headA = ( headA == null ) ? b: headA.next;
            headB = ( headB == null ) ? a: headB.next;
        }
        return headA;
    }
}
