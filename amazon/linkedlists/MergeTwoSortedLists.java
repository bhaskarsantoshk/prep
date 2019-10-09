package amazon.linkedlists;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if ( A  == null && B == null ) return  null;
        if ( A  == null ) return B;
        if ( B == null ) return A;
        ListNode cur = new ListNode(0);
        ListNode res = cur;

        while ( A != null && B != null ){
            if ( A.val < B.val ){
                cur.next = A;
                A = A.next;
            }
            else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }
        if ( A != null ){
            cur.next = A;
        }
        if ( B != null ){
            cur.next = B;
        }
        return res.next;
    }
}
