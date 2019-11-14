package parallel_programming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ReciprocalArraySum {
    static double sum1;
    static double sum2;
    public static double seqArraySum( double[] a){
        long startTime = System.nanoTime();
        sum1 = 0;
        sum2 = 0;
        for ( int i=0; i<a.length/2; i++){
            sum1+= 1/a[i];
        }
        for ( int i=a.length/2 ; i<a.length; i++){
            sum2 += 1/a[i] ;
        }
        double sum = sum1 + sum2;
        long timeInNanos = System.nanoTime() - startTime;
        printResults ( "seqArraySum", timeInNanos, sum);
        return sum;
    }

    public static double parArraySum( double[] a){
        long startTime = System.nanoTime();
        SumArray t = new SumArray(a, 0, a.length);
        ForkJoinPool.commonPool().invoke(t);
        double sum = t.ans;
        long timeInNanos = System.nanoTime() - startTime;
        printResults ( "parArraySum", timeInNanos, sum);
        return sum;
    }

    public static void printResults(String name, long timeInNanos, double sum) {
        System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.5f \n", name, timeInNanos/1e6, sum);
    }

    private static class SumArray extends RecursiveAction{
        static int SEQUENTIAL_THRESHOLD = 1000;
        int lo;
        int hi;
        double [] arr;
        double ans ;

        SumArray(double[] a, int lo, int hi){
            this.lo = lo;
            this.hi = hi;
            this.arr = a;
        }

        @Override
        protected void compute() {
            if ( hi - lo <= SEQUENTIAL_THRESHOLD ){
                for ( int i = lo; i<hi; i++){
                    ans += 1/ arr[i] ;
                }
            }
            else{
                SumArray left = new SumArray(arr, lo, (hi+lo)/2 );
                SumArray right = new SumArray(arr, (hi+lo)/2, hi);
                left.fork(); // async
                right.compute(); // executing parallel
                left.join();
                ans = left.ans + right.ans;
            }
        }
    }

    public static void main(String[] args){
        int n = 1000000;
        double a[] = new double[n];
        for ( int i=0; i<n; i++){
            a[i] = i+1;
        }
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        for ( int i=0; i<5; i++){
            System.out.printf( "Run %d\n", i);
            seqArraySum(a);
            parArraySum(a);
        }
    }
}
