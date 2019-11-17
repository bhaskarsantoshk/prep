package ctci.C8RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithDups {
    ArrayList<String> printPerms(String s){
       ArrayList<String> permutations = new ArrayList<>();
       HashMap<Character, Integer> map = buildFreqTables (s);
       printPerms(map, "", s.length(), permutations);
       return permutations;
    }

    private void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> permutations) {
        if ( remaining == 0){
            permutations.add(prefix);
        }
        for ( Character c: map.keySet()){
         int count = map.get(c);
         if ( count > 0){
             map.put(c, c-1);
             printPerms(map, prefix+c, remaining-1, permutations);
             map.put(c, count);
         }
        }
    }

    private HashMap<Character, Integer> buildFreqTables(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for ( char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return map;
    }
}
