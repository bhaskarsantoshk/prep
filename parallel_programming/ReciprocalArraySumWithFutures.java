package parallel_programming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ReciprocalArraySumWithFutures {
    public static double parArraySum(double[] a){
        SumArray t = new SumArray(a, 0, a.length-1);
        double sum = ForkJoinPool.commonPool().invoke(t);
        System.out.println(t);
    }



    static class SumArray extends RecursiveTask<Double> {
        static int SEQUENTIAL_THRESHOLD = 1000;
        int lo, hi;
        double[] arr;

        public SumArray(double[] a, int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
            this.arr = a;
        }

        @Override
        protected Double compute() {
            if ( hi - lo <= SEQUENTIAL_THRESHOLD){
                double sum = 0;
                for ( int i = lo; i<hi; i++){
                    sum+= 1/i;
                }
                return sum;
            }
            else{
                int mid = (lo+hi)/2;
                SumArray left = new SumArray(arr, lo, mid);
                SumArray right = new SumArray(arr, mid, hi);
                left.fork(); // future async
                double rightSum = right.compute();
                double leftSum = left.join();
                return leftSum+ rightSum;
            }
        }
    }
}
