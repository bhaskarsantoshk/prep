package amazon.heaps_and_maps;

import amazon.linkedlists.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if ( a == null || a.size() == 0 ) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(a.size(), (x, y)->x.val-y.val);
        for ( ListNode node : a){
            if ( node != null ){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while ( !minHeap.isEmpty() ){
            tail.next = minHeap.poll();
            tail = tail.next;
            if ( tail.next != null ){
                minHeap.offer(tail.next);
            }
        }
        return dummy.next;
    }
}
