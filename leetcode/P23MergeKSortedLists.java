package leetcode;

import amazon.linkedlists.ListNode;

import java.util.PriorityQueue;

public class P23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a,b)-> a.val-b.val);
        for ( ListNode node : lists){
            if ( node != null ){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while ( !minHeap.isEmpty()){
            tail.next = minHeap.poll();
            tail = tail.next;
            if ( tail.next != null){
                minHeap.offer(tail.next);
            }
        }
        return dummy.next;
    }
}
