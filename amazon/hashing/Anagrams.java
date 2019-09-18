package amazon.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> group = new HashMap<>();
        for ( int i=0; i<A.size(); i++){
            char a[] = new char[26];
            for ( char c: A.get(i).toCharArray()){
                a[c-'a']++;
            }
            String anagram = new String(a);
            if ( group.containsKey(anagram)){
                group.get(anagram).add(i+1);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i+1);
                group.put(anagram, list);
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for ( String anagram: group.keySet()){
            result.add(group.get(anagram));
        }
        return result;
    }
}
