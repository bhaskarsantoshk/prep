package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if ( pattern.length() != s.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for ( int i=0; i<pattern.length(); i++){
            char c= pattern.charAt(i);
            if ( map.containsKey(c)){
                if ( !map.get(c).equals(s[i])){
                    return false;
                }
            }
            else{
                if ( set.contains(s[i])){
                    return false;
                }
                map.put(c, s[i]);
                set.add(s[i]);
            }
        }
        return true;
    }
}
