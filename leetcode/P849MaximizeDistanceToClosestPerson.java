package leetcode;

public class P849MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int start = -1, maxGap = -1;
        for ( int i=0; i<seats.length; i++){
            if ( seats[i]  == 0){
                continue;
            }
            if ( start == -1){
                maxGap = Math.max(maxGap, i);
            }
            else{
                maxGap = Math.max ( maxGap, (i-start)/2);
            }
            start = i;
        }

        if ( seats[seats.length-1]  == 0){
            maxGap = Math.max(maxGap, seats.length-1-start);
        }
        return maxGap;
    }
}
