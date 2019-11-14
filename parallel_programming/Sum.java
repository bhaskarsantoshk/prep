package parallel_programming;

import java.util.concurrent.RecursiveAction;

public class Sum extends RecursiveAction {
    int lo, hi, ans, a[];

    public Sum(int lo, int hi, int[] a){
        this.lo = lo;
        this.hi = hi;
        this.a = a;
    }
    @Override
    protected void compute() {
        if ( hi - lo <= 5 ){
            for ( int i=lo; i<hi; i++){
                ans+= a[i];
            }
        }
        else{
            Sum left = new Sum(lo, (lo+hi)/2, a);
            Sum right = new Sum( (lo+hi)/2, hi, a);
            left.fork();
            right.compute();
            left.join();
            ans = left.ans+right.ans;
        }
    }
}
