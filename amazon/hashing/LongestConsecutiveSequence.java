package amazon.hashing;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final List<Integer> A) {
        Set<Integer> set = new HashSet<>();
        for ( int i=0; i<A.size(); i++){
            set.add(A.get(i));
        }
        int ans  = 0;
        for ( int i=0; i<A.size(); i++){
            int num = A.get(i);
            int left = num-1;
            int right = num+1;
            while ( set.remove(left)) left--;
            while ( set.remove(right)) right++;
            ans = Math.max ( ans, right-left-1);
            if ( set.isEmpty() ){
                return ans;
            }
        }
        return ans;
    }


}
