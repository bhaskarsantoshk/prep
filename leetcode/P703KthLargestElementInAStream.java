package leetcode;

import java.util.PriorityQueue;

public class P703KthLargestElementInAStream {
    final PriorityQueue<Integer> minHeap;
    final int k;
    public P703KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for ( int n: nums){
            add(n);
        }
    }

    public int add(int val) {
        if ( minHeap.size() < k){
            minHeap.offer(val);
        }
        else if ( minHeap.peek() < val ){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
