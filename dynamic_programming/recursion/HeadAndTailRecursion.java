package dynamic_programming.recursion;

import amazon.linkedlists.ListNode;

public class HeadAndTailRecursion {
    public void traverse1( ListNode head ){
        if ( head!= null ){
            traverse1(head.next);
            System.out.print(head.val+" ");
        }
    }

    public void traverse2( ListNode head ){
        if ( head!= null ){
            System.out.print( head.val );
            traverse2(head.next);
        }
    }
}
