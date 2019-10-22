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
                for ( int k=0; k<len/2;k++){
                    lsum+= (s[i+k] -'0');
                    rsum+= (s[i+k+len/2] - '0')
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

    public static int maxSubStringLengthDP( char[] s){
        int n = s.length;
        int maxLen = 0;
        int sum[][] = new int[n][n];
        for ( int i=0; i<n; i++){
            sum[i][i] = s[i]-'0';
        }
        for ( int len = 2; len<n; len++){
            for ( int i=0; i< n-len+1; i++){
                int j = i+len-1;
                int k = len/2;
                sum[i][j] = sum[i][j-k]+ sum[j-k+1][j];
                if ( len% 2 == 0 && sum[i][j-k] == sum[j-k+1][j] && len > maxLen){
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }
}
