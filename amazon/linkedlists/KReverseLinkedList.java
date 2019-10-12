package amazon.linkedlists;

public class KReverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        ListNode begin;
        if ( A == null || A.next == null || B ==1 ){
            return A;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = A;
        begin = dummyHead;
        int i=0;
        while ( A != null ){
            i++;
            if ( i%B == 0){
                begin = reverse( begin, A.next);
                A = begin.next;
            }
            else{
                A = A.next;
            }
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode cur = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = cur;
        while ( cur != end){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        begin.next = prev;
        first.next = cur;
        return first;
    }
}
