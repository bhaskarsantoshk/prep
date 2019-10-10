package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P149MaxPointsonALine {
    public int maxPoints(int[][] points) {
        if ( points == null || points.length == 0){
            return 0;
        }
        if ( points.length <= 2){
            return points.length;
        }
        int max = 2;
        for  ( int i=0; i < points.length ; i++){
            Map<Integer, Integer> slopes = new HashMap<>();
            int localMax = 0;
            for ( int j=i+1; j<points.length; j++){
                int numerator = points[j][1]-points[i][1];
                int denominator = points[j][0] - points[i][0];
                int sign =  ( (numerator>0 && denominator<0) || (numerator<0 && denominator>0) ) ? -1 : 1;
                numerator = Math.abs(numerator);
                denominator = Math.abs(denominator);
                int gcd  = gcd(numerator, denominator);
                numerator = gcd == 0 ? numerator: numerator/gcd;
                denominator = gcd == 0 ? denominator: denominator/gcd;

                int m= sign * ( numerator+ denominator) * ( numerator + denominator +1 )/ 2 + denominator;
                slopes.put(m, slopes.getOrDefault(m,0)+1);
                if ( m == 0){
                    continue;
                }
                localMax = Math.max ( localMax, slopes.get(m));
            }
            max = Math.max ( max, localMax+ slopes.getOrDefault(0, 0)+1);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if ( b == 0) return a;
        return gcd(b, a%b);
    }
}
