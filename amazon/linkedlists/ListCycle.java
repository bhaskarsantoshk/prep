package amazon.linkedlists;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        if ( cycleExists(a)){
            ListNode slow = a;
            ListNode fast = a;
            while ( fast.next != null && fast.next.next!= null ){
                slow = slow.next;
                fast = fast.next.next;
                if ( slow == fast ){
                    break;
                }
            }
            slow = a;
            while ( slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        else{
            return null;
        }
    }

    private boolean cycleExists(ListNode a) {
        if ( a == null || a.next == null) return false;
        ListNode slow = a;
        ListNode fast = a;
        while ( fast.next != null && fast.next.next!= null ){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ){
                return true;
            }
        }
        return false;
    }
}
