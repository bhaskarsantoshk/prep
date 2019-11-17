package ctci.C8RecursionAndDynamicProgramming;

public class PaintFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if ( image[sr][sc] == newColor){
            return image;
        }
        dfs ( image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        if ( i < 0 || i>= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor){
            return;
        }
        image[i][j] = newColor;
        dfs ( image, i+1, j, newColor, oldColor );
        dfs ( image, i, j+1, newColor, oldColor );
        dfs ( image, i-1, j, newColor, oldColor );
        dfs ( image, i, j-1, newColor, oldColor );
    }
}
