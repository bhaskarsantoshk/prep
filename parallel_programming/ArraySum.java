package parallel_programming;

import java.util.concurrent.ForkJoinPool;

public class ArraySum {
    public static void sum( int[] a){
        Sum t = new Sum( 0, a.length, a);
        ForkJoinPool.commonPool().invoke(t);
        System.out.println(t.ans);

    }

    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        sum(a);
    }
}
