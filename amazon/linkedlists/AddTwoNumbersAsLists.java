package amazon.linkedlists;

public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while ( A != null || B != null || carry != 0){
            ListNode cur = new ListNode(0);
            int sum =  ( A == null ? 0 : A.val) + (B == null ? 0: B.val ) + carry;
            cur.val = sum % 10;
            carry = sum/10;
            prev.next = cur;
            prev = cur;
            A = ( A == null )? A: A.next;
            B = ( B == null )? B: B.next;
        }
        return head.next;
    }
}
