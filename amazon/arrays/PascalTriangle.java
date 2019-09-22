package amazon.arrays;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if ( A <= 0) return result;
        if ( A == 1) {
            result.add(new ArrayList<>());
            result.get(0).add(1);
            return result;
        }
        result.add( new ArrayList<>());
        result.get(0).add(1);
        for ( int i=1; i<A; i++){
            result.get(i).add(1);
            for ( int j=0; j<result.get(i-1).size()-1; j++){
                result.add( new ArrayList<>());
                result.get(i).add( result.get(i-1).get(j)+result.get(i-1).get(j+1));
            }
            result.get(i).add(1);
        }
        return result;
    }
}
