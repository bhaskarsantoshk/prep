package dynamic_programming.overlapping_sub_problems;

public class Example_4_2_MinimumCostToTravelBetweenStations {
    int minCost = Integer.MAX_VALUE;
    public int calculateMinCost( int[][] cost, int s, int d){
        if ( s == d || s == d-1){
            return cost[s][d];
        }
        for ( int i= s+1; i<d; i++){
            minCost = Math.min (minCost, calculateMinCost(cost, s, i) + calculateMinCost(cost, i, d));
        }
        return minCost;
    }
}
