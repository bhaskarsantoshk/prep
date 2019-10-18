package microsoft.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordLadderI {
    public int solve(String start, String end, ArrayList<String> words) {
        Set<String> dict = new HashSet<String>(words);
        dict.add(end);
        Set<String> reached = new HashSet<>();
        reached.add(start);
        int steps = 1;
        while ( !reached.contains(end)){
            Set<String> toBeAdded = new HashSet<>();
            for ( String each: reached){
                for ( int i=0; i<each.length(); i++){
                    char[] chars= each.toCharArray();
                    for ( char ch='a'; ch<='z'; ch++){
                        chars[i]= ch;
                        String word = new String(chars);
                        if ( dict.contains(word)){
                            toBeAdded.add(word);
                            dict.remove(word);
                        }
                    }
                }
            }
            if ( toBeAdded.size() == 0 ) return 0;
            reached = toBeAdded;
            steps++;
        }
        return steps;
    }
}
