package amazon.strings;

public class MinimumCharactersRequiredToMakeAStringPalindromic {
    public int solve(String A) {
        char []c= A.toCharArray();
        int count =0;
        for ( int i= A.length()-1; i>=0; i--){
            if ( isPalindrome(c, 0, i)){
                return count;
            }
            count++;
        }
        return count;
    }

    private boolean isPalindrome(char[] c, int i, int j) {
        while ( i< j){
            if ( c[i++] != c[j--]){
                return  false;
            }
        }
        return true;
    }
}
