package amazon.strings;

public class ImplementStrStr {
    public int strStr(final String A, final String B) {
        if ( A.isEmpty() || B.isEmpty() ) return -1;
        for ( int i=0; i<= A.length()-B.length(); i++ ){
            for ( int j=0; j< B.length() && A.charAt(i+j) == B.charAt(j); j++){
                if ( j == B.length()-1 ) return i;
            }
        }
        return -1;
    }
}
