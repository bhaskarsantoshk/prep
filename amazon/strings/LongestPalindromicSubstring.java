package amazon.strings;

public class LongestPalindromicSubstring {
    int lo , maxLen ;
    public String longestPalindrome(String A) {
        int len = A.length();
        if ( len < 2 ) return A;
        for ( int i=0; i< len-1; i++){
            extendPalindrome(A, i, i);
            extendPalindrome (A, i, i+1);
        }
        return A.substring( lo, lo+maxLen);
    }

    private void extendPalindrome(String a, int i, int j) {
        while ( i>=0 && j<a.length() && a.charAt(i) == a.charAt(j)){
            i--;
            j++;
        }
        if ( maxLen > j-(i+1)){
            lo = i+1;
            maxLen = j-i-1;
        }
    }

}
