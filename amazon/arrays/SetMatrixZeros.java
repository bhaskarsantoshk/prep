package amazon.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int[] rows = new int[a.size()];
        int[] cols = new int[a.get(0).size()];
        Arrays.fill(rows,1);
        Arrays.fill(cols, 1);
        for ( int i=0; i<a.size(); i++){
            for ( int j= 0; j<a.get(0).size(); j++){
                if ( a.get(i).get(j) == 0){
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }
        for ( int i=0; i<a.size(); i++){
            for ( int j= 0; j<a.get(0).size(); j++){
                if ( rows[i] == 0 || cols[j] == 0){
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}
