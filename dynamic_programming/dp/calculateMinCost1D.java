package dynamic_programming.dp;

public class calculateMinCost1D {
    public int calculateMinCost( int[][] cost){
        int n = cost.length;
        int minCost[] = new int[n];
        minCost[0] = 0;
        minCost[1] = cost[0][1];
        for ( int i = 0; i< n; i++){
            for ( int j = i+1; j< n; j++){
                minCost[j] = Math.min (minCost[j], minCost[i]+ cost[i][j]);
            }
        }
        return minCost[n-1];
    }
}
