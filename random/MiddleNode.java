package random;

public class MiddleNode {

    public Node getMiddle( Node head ){
        if ( head == null ) return null;
        if ( head.next != null ) return head;
        if ( ifCycleExists(head )){
            return null;
        }
        Node slow = head;
        Node fast = head;
        while ( fast != null && fast.next!= null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private boolean ifCycleExists(Node head) {
        Node slow = head;
        Node fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ){
                return true;
            }
        } while ( fast!= null && fast.next != null );
        return false;
    }

    // 1->2->3->4->5-> 6-> 7->8->3
    // Slow = 3, Fast = 3

    // 7, 7




    class Node{
        int data;
        Node next;
    }
}
