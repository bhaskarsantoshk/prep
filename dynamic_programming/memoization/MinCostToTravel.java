package dynamic_programming.memoization;

public class MinCostToTravel {
    public int calculateMinCost(int[][] cost, int s, int d){
        int memo[][] = new int[s+1][d+1];
        return calculateMinCost(cost, memo, s, d);
    }

    private int calculateMinCost(int[][] cost, int[][] memo, int s, int d) {
        if ( memo[s][d] != 0){
            return memo[s][d];
        }
        if ( s == d || s == d-1){
            memo[s][d] = cost[s][d];
        }
        int minCost = cost[s][d];
        for (int i= s+1; i<d; i++){
            minCost= Math.min ( minCost, calculateMinCost(cost, memo, s, i)+ calculateMinCost(cost, memo, i, d));
        }
        return memo[s][d]= minCost;
    }
}
