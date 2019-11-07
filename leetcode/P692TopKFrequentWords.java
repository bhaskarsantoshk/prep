package leetcode;

import java.util.*;

public class P692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        for ( String word: words ){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b)-> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        for ( Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if ( pq.size() > k ){
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while ( !pq.isEmpty() ){
            result.add(0, pq.poll().getKey());
        }
        return result;
    }
}
