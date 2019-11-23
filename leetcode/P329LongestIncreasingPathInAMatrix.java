package leetcode;

public class P329LongestIncreasingPathInAMatrix {
    public static final int [][] directions = {{0,1}, {1,0}, {0,-1},{-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if ( matrix == null || matrix.length == 0 ){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 1;
        int[][] cache = new int[m][n];
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                int len = dfs( matrix, i, j, m, n, cache);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if ( cache[i][j] != 0 ){
            return cache[i][j];
        }
        int max = 1;
        for ( int[] dir: directions ){
            int x = i+ dir[0] , y=j+ dir[1];
            if ( x < 0 || x>= m || y < 0 || y>= n || matrix[x][y] <= matrix[i][j]){
                continue;
            }
            int len = 1+ dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}
