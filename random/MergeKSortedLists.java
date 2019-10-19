package random;

import amazon.linkedlists.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists{
        public ListNode mergeKLists(ListNode[] lists) {
            if ( lists == null ) return null;
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a,b)-> a.val-b.val);
            for ( ListNode node: lists){
                if ( node != null ){
                    minHeap.offer(node);
                }
            }
            while ( !minHeap.isEmpty()){
                tail.next = minHeap.poll();
                tail = tail.next;
                if ( tail.next != null ){
                    minHeap.offer(tail.next);
                }
            }
            return dummy.next;
        }
}
