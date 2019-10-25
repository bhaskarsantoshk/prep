package dynamic_programming.practice_questions;

public class EditDistance {
    public static int editDistance( char[] str1, char[] str2){
        return editDistance(str1, 0, str2, 0);
    }

    private static int editDistance(char[] str1, int i, char[] str2, int j) {
        if ( str1 == null || i == str1.length){
            return str2.length-j;
        }
        if ( str2 == null || j == str2.length){
            return str1.length-i;
        }

        if ( str1[i] == str2[j] ){
            return editDistance(str1, i+1, str2, j+1);
        }

        int delete = editDistance(str1, i+1, str2, j);
        int replace = editDistance(str1, i+1, str2, j+1);
        int insert = editDistance(str1, i, str2, j+1);

        return Math.min ( delete, Math.min( insert, replace)) + 1;
    }


    public static void main(String[] args){
        System.out.print(editDistanceBottomUp("Batman".toCharArray(), "Catwoman".toCharArray()));
    }

    private static int editDistanceBottomUp (  char[] str1, char[] str2 ){
        int memo[][] = new int[str1.length+1][str2.length+1];
        for ( int i=0; i<=str1.length; i++){
            memo[i][0] = i;
        }
        for ( int j=0; j<=str2.length; j++){
            memo[0][j] = j;
        }
        for ( int i=1; i<=str1.length; i++){
            for ( int j=1; j<=str2.length; j++){
                if ( str1[i-1] == str2[j-1]){
                    memo[i][j] = memo[i-1][j-1];
                }
                else{
                    memo[i][j] = Math.min ( memo[i-1][j], Math.min( memo[i][j-1], memo[i-1][j-1]))+1;
                }
            }
        }
        return memo[str1.length][str2.length];
    }
}
