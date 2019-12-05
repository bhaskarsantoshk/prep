package leetcode;

import java.util.Arrays;

public class P1160FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
            int sum = 0;
            int [] count = new int[26];
            for ( char c: chars.toCharArray()){
                count[c-'a']++;
            }
            for ( String word: words){
                int copy[] = Arrays.copyOf(count, count.length);
                int len = 0;
                for ( char c: word.toCharArray()){
                    if ( copy[c-'a'] > 0){
                        len++;
                        copy[c-'a']--;
                    }
                }
                if ( len == word.length()){
                    sum+= len;
                }
            }
            return sum;
    }
}
