package leetcode;

import amazon.linkedlists.ListNode;

public class P25ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if ( head == null || head.next == null || k ==1 ){
            return head;
        }
        int i=0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode begin = dummyHead;
        while ( head != null ){
            i++;
            if ( i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            else{
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode cur = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = cur;
        while ( cur!= end ){
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
