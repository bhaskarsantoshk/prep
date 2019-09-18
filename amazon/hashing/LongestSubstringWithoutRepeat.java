package amazon.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int index = 0;
        for ( int i=0; i<A.length(); i++){
            while ( set.contains(A.charAt(i))){
                set.remove(A.charAt(index++));
            }
            set.add(A.charAt(i));
            result = Math.max(result, i-index+1);
        }
        return result;
    }
}
