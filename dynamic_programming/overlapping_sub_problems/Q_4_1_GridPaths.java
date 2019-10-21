package dynamic_programming.overlapping_sub_problems;

public class Q_4_1_GridPaths {
    public int countWays( int n) {
       return countWays(n, n);
    }

    private int countWays(int m, int n) {
        if ( m == 1 || n == 1) return 1;
        return countWays(m-1, n)+ countWays(m, n-1);
    }

}
