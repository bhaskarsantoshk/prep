package dynamic_programming.strategy_for_dp_question;

public class Example_8_3_ScoreN {
    public int waysToScore ( int n ){
        if ( n < 0) return 0;
        if ( n == 0 ) return 1;
        return waysToScore(n-3)+ waysToScore(n-5) + waysToScore(n-10);
    }

    //Bottom up
    public int waysToScoreBottomUp( int n){
        int memo[]= new int[n+1];
        memo[0] = 1;
        for ( int i=1; i<=n; i++){
            if ( i-3 >= 0){
                memo[i] += memo[i-3];
            }
            if ( i-5 >= 0){
                memo[i]+= memo[i-5];
            }
            if ( i-10 >=0 ){
                memo[i]+= memo[i-10];
            }
        }
        return memo[n];
    }
}
