package ctci.C16moderate;

import java.util.HashMap;

public class WordFrequencies {
    HashMap<String, Integer> setUpDictionary ( String[] book ){
        HashMap<String, Integer> table = new HashMap<>();
        for ( String word: book){
            word = word.trim().toLowerCase();
            table.put(word, table.getOrDefault(word, 0)+1);
        }
        return table;
    }

    int getFrequency ( HashMap<String, Integer> table, String word){
        if ( table == null || table.size() == 0){
            return 0;
        }
        word = word.toLowerCase().trim();
        return table.getOrDefault(word, 0);
    }
}
