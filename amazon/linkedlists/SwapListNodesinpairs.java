package amazon.linkedlists;

public class SwapListNodesinpairs {
    public ListNode swapPairs(ListNode A) {
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode cur = dummy;
        System.out.println(dummy.next.val);
        while ( cur.next != null && cur.next.next != null ){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
            System.out.println(dummy.next.val);
        }
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        SwapListNodesinpairs obj = new SwapListNodesinpairs();
        ListNode result = obj.swapPairs(A);
        while (result != null ){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
