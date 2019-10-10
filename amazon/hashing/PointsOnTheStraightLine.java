package amazon.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnTheStraightLine {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if ( a == null || a.size()==0 ){
            return 0;
        }
        if ( a.size() <=2 ){
            return a.size();
        }
        int max = 2;
        for ( int i=0; i<a.size(); i++){
            int localMax = 0;
            HashMap<Integer, Integer> slopes = new HashMap<>();
            for ( int j = i+1; j< a.size(); j++){
                int numerator = b.get(j) - b.get(i);
                int denominator = a.get(j) - a.get(i);
                int sign = ( numerator >0 && denominator<0) || ( numerator<0 && denominator>0) ? -1 : 1;
                numerator = Math.abs(numerator);
                denominator = Math.abs ( denominator);
                int gcd = gcd(numerator, denominator);
                numerator = ( gcd == 0) ? numerator : numerator/gcd;
                denominator = ( gcd == 0 ) ? denominator: denominator/gcd;
                int m = sign * ( numerator+ denominator) * ( numerator+ denominator+1)/2 + denominator;
                slopes.put ( m, slopes.getOrDefault(m, 0)+1);
                if ( m == 0){
                    continue;
                }
                localMax = Math.max ( localMax, slopes.get(m));
            }
            max = Math.max(localMax+ 1+ slopes.getOrDefault(0, 0), max);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
