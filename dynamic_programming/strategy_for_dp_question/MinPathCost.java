package dynamic_programming.strategy_for_dp_question;

public class MinPathCost {
    public int minPathCost( int cost[][], int m , int n){
        if ( m == 0 && n == 0) return cost[0][0];
        if ( m == 0 ) return minPathCost(cost, m, n-1) + cost[0][n];
        if ( n == 0 ) return minPathCost(cost, m-1, n) + cost[m][0];
        int x = minPathCost(cost, m-1, n);
        int y = minPathCost(cost, m, n-1);
        return Math.min ( x, y) + cost[m][n];
    }

    public int minPathCostMemoized(int cost[][], int m, int n){
        int memo[][] = new int[m+1][n+1];
        return minPathCost(cost, m, n, memo);
    }

    private int minPathCost(int[][] cost, int m, int n, int[][] memo) {
        if ( memo[m][n] != 0){
            return memo[m][n];
        }
        if ( m == 0 && n == 0){
            memo[m][n] = cost[m][n];
        }
        else if ( m == 0 ){
            memo[m][n] = minPathCost(cost, m, n-1, memo) + cost[m][n];
        }
        else if ( n == 0 ){
            memo[m][n] = minPathCost(cost, m-1, n, memo)+ cost[m][n];
        }
        else{
            int x = minPathCost(cost, m-1, n, memo);
            int y = minPathCost(cost, m, n-1, memo);
            memo[m][n] = Math.min(x, y) + cost[m][n];
        }
        return memo[m][n];
    }


    //memo of m rows and n cols
    private int minPathCostBottomUp ( int[][] cost, int m , int n, int[][] memo){
        memo[0][0] = cost[0][0];
        for ( int i=1; i<m; i++){
            memo[i][0] = memo[i-1][0]+ cost[i][0];
        }
        for ( int j=1; j<n; j++){
            memo[0][j] = memo[0][j-1]+cost[0][j];
        }

        for ( int i=1; i<m;i++){
            for ( int j=1; j<n; j++){
                memo[i][j] = Math.min ( memo[i-1][j] , memo[i][j-1])+cost[i][j];
            }
        }
        return memo[m-1][n-1];
    }
}
