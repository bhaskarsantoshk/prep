package ctci.C8RecursionAndDynamicProgramming;

import java.util.Arrays;

public class TripleStep {
    int countWays( int n){
        if ( n < 0 ){
            return 0;
        }
        else if ( n == 0){
            return 1;
        }
        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }

    int countWaysMemoized( int n){
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private int countWays(int n, int[] memo) {
        if ( n < 0){
            return 0;
        }
        else if ( n == 0){
            return 1;
        }
        else if ( memo[n] > -1){
            return memo[n];
        }
        else{
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }
}
