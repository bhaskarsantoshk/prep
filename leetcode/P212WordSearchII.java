package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P212WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result  = new ArrayList<>();
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                dfs ( board, result, root,i, j);
            }
        }
        Collections.sort(result);
        return result;
    }

    private void dfs(char[][] board, List<String> result, TrieNode p, int i, int j) {
        char c = board[i][j];
        if ( c == '#' || p.next[c-'a']== null ){
            return;
        }
        p = p.next[c-'a'];
        if ( p.word != null ){
            result.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        if ( i > 0 ){
            dfs(board, result, p, i-1, j);
        }
        if ( j > 0 ){
            dfs(board, result, p, i, j-1);
        }
        if ( i < board.length-1){
            dfs ( board, result, p, i+1, j);
        }
        if ( j < board[0].length-1){
            dfs ( board, result, p, i, j+1);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for ( String word: words){
            TrieNode p = root;
            for ( char c: word.toCharArray()){
                int i = c-'a';
                if ( p.next[i] == null ){
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
}
