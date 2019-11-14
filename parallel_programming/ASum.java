package parallel_programming;

import java.util.concurrent.RecursiveAction;

  class ASum extends RecursiveAction {
    int[] A;
    int low, high;
    int sum;
    @Override
    protected void compute() {
        sum = 0;
        for ( int i=low; i<=high; i++){
            sum+= A[i];
        }
    }
}
