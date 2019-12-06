package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class P1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for ( int n: arr1){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int index = 0;
        for ( int num: arr2){
            while ( map.get(num ) > 0){
                arr1[index++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        for ( int num: map.keySet()){
            while (map.get(num) > 0){
                arr1[index++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        return arr1;
    }
}
