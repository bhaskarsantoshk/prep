package amazon.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        init(board, n);
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[n+n-1];
        boolean [] antidiag = new boolean[n+n-1];
        helper(result, board, 0, cols, diag, antidiag, n);
        return result;
    }

    private void helper(ArrayList<ArrayList<String>> result, char[][] board, int rowIndex, boolean[] cols, boolean[] diag, boolean[] antidiag, int n) {
        if ( rowIndex == n ){
            ArrayList<String> cur = turnToList(board, n);
            result.add(cur);
            return;
        }

        for ( int colIndex =0; colIndex < n; colIndex++){
            if ( isValid(board, rowIndex, colIndex, cols, diag, antidiag, n)){
                board[rowIndex][colIndex] = 'Q';
                cols[colIndex] = true;
                diag[n-rowIndex+colIndex-1] = true;
                antidiag[rowIndex+colIndex] = true;
                helper(result, board, rowIndex+1, cols, diag, antidiag, n);
                board[rowIndex][colIndex] = '.';
                cols[colIndex] = false;
                diag[n-rowIndex+colIndex-1] = false;
                antidiag[rowIndex+colIndex] = false;
            }
        }
    }

    private boolean isValid(char[][] board, int rowIndex, int colIndex, boolean[] cols, boolean[] diag, boolean[] antidiag, int n) {
        if ( cols[colIndex] || diag[n-rowIndex+colIndex-1] || antidiag[rowIndex+colIndex]){
            return false;
        }
        return true;
    }

    private ArrayList<String> turnToList(char[][] board, int n) {
        ArrayList<String> list = new ArrayList<>();
        for ( int i=0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for ( int j=0; j<n; j++){
                row.append(board[i][j]);
            }
            list.add(row.toString());
        }
        return list;
    }

    private void init(char[][] board, int n) {
        for ( int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
    }

}
