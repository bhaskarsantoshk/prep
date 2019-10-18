package microsoft.graphs;

import java.util.*;

public class SmallestSequenceWithGivenPrimes {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        int primes[] = new int[3];
        primes[0] = A;
        primes[1] = B;
        primes[2] = C;
        Arrays.sort(primes);
        return generateSuperUglyNumbers(D, primes);
    }

    private ArrayList<Integer> generateSuperUglyNumbers(int n, int[] primes) {
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int prime: primes){
            if ( !set.contains(prime) ){
            minHeap.offer(prime);
            }
            set.add(prime);
        }
        while ( count < n){
            Integer node = minHeap.poll();
            result.add(node);
            count++;
            if ( count == n){
                break;
            }
            for ( int prime: primes){
                int num = node * prime;
                if ( !set.contains(num)){
                    set.add(num);
                    minHeap.offer(num);
                }
            }
        }
        return result;
    }
}
