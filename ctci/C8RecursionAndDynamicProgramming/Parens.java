package ctci.C8RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Parens {
    public List<String> generateParanthesis(int n){
        List<String> res = new ArrayList<>();
        backtrack( res, 0, 0, n, "");
        return res;
    }

    private void backtrack(List<String> res, int open, int closed, int n, String s) {
        if ( open + closed == 2 * n ){
            res.add(s);
        }
        if ( open < n ){
            backtrack(res, open+1, closed, n, s+"(");
        }
        if ( closed < open ){
            backtrack(res, open, closed+1, n, s+")");
        }
    }
}
