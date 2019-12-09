package random;

import java.util.*;

public class SellingProducts {
    public static int deleteProducts(List<Integer> ids, int n){
        Map<Integer, Integer> map = new HashMap<>();
        for ( Integer num: ids){
            map.put(num , map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b)-> a.getValue()-b.getValue()
        );
        for ( Map.Entry<Integer, Integer> entry: map.entrySet() ){
            pq.offer(entry);
        }
        while ( !pq.isEmpty() && n!= 0){
            //System.out.print(pq.peek().getValue());
            if ( pq.peek().getValue() == 1){
                pq.poll();
                //System.out.print(pq.size());
            }
            else{
               pq.peek().setValue(pq.peek().getValue()-1);
            }
            n--;
        }
        return pq.size();
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        int a[] = {1,1,5,5};
        for ( int num: a){
            list.add(num);
        }
        System.out.print(deleteProducts(list, 2));
    }
}
