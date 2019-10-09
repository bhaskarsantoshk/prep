package random;


import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargestElement ( int[] nums, int k){
        this.k = k;
        minHeap = new PriorityQueue<>();
        for ( int num: nums){
            add(num);
        }
    }

    private int add(int num) {
        if ( minHeap.size() < k ){
            minHeap.add(num);
        }
        else if ( minHeap.peek() < num ){
            minHeap.poll();
            minHeap.offer(num);
        }
        return minHeap.peek();
    }

}
