package amazon.linkedlists;

public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
       int len = 0;
       ListNode dummy = new ListNode(0);
       dummy.next = A;
       ListNode slow = dummy, fast = dummy;
       while ( fast.next != null ){
           len++;
           fast = fast.next;
       }
       int len2 = len - B % len;
       while ( len2 > 0){
           slow = slow.next;
           len2--;
       }
       fast.next = dummy.next;
       dummy.next = slow.next;
       slow.next = null;
       return dummy.next;
    }
}
