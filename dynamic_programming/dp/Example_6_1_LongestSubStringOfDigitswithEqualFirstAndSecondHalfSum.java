package dynamic_programming.dp;

public class Example_6_1_LongestSubStringOfDigitswithEqualFirstAndSecondHalfSum {
    public static int maxSubStringLength ( char[] s ){
        int n = s.length;
        int maxLen = 0;
        for ( int i = 0; i<n; i++){
            for ( int j = i+1; j<n; j+=2){
                int len = j-i+1;
                if ( maxLen >= len ){
                    continue;
                }
                int lsum = 0, rsum =0;
                int start = i, end = j;
                while ( start < end ){
                    lsum+= s[start++] - '0';
                    rsum+= s[end--] - '0';
                }
                if ( lsum == rsum ){
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        char[] s = "9430723".toCharArray();
        System.out.println(maxSubStringLength(s));
    }
}
