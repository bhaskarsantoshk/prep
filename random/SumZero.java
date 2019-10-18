package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumZero {
    class Pair{
        int first;
        int second;

        Pair ( int first, int second ){
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first+" "+ second;
        }
    }

    public static void main(String [] args){
        int a[]= {
                -20, 4, -2, -4, 8, 6, 22, 10, -12
        };
        SumZero obj = new SumZero();
        System.out.println(obj.getNonZeroSumFarthestPair(a));
    }

    private List<Pair> getKSumPair(int [] a, int k){
        Arrays.sort(a);
        List<Pair> result = new ArrayList<>();
        int start = 0;
        int end = a.length-1;
        while ( start < end ){
            int sum =  a[start] + a[end];
            if ( sum == k){
                Pair pair = new Pair(a[start], a[end]);
                result.add(pair);
                start++;
                end--;
            }
            else if ( sum > k){
                end--;
            }
            else{
                start++;
            }
        }
        return result;
    }

    private List<Pair> getNonZeroClosestPair( int [] a){
        if ( a == null || a.length == 0 || a.length < 2){
            return null;
        }
        Arrays.sort (a);
        int req_sum = getSumClosestToZero(a);
        return getKSumPair(a, req_sum);
    }

    private List<Pair> getZeroSumPair(int[] a){
        if ( a == null || a.length == 0 || a.length < 2){
            return null;
        }
        return getKSumPair(a, 0);
    }

    private int getSumClosestToZero(int[] a) {
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = a.length-1;
        while ( start < end){
            int sum = a[start] + a[end];
            if ( sum != 0 && Math.abs (sum) < Math.abs(result)){
                result = sum;
            }

            if ( sum < 0){
                start++;
            }
            else{
                end--;
            }
        }
        return result;
    }


    private List<Pair> getNonZeroSumFarthestPair( int [] a){
        if ( a == null || a.length == 0 || a.length < 2){
            return null;
        }
        Arrays.sort (a);
        int req_sum = Math.abs(getSumFarthestToZero(a));
        return getKSumPair(a, req_sum);
    }

    private int getSumFarthestToZero(int[] a) {
        int min1 = a[0];
        int min2 = a[1];
        int max1 = a[a.length-1];
        int max2 = a[a.length-2];
        int sum1 = Math.abs ( min1 + min2);
        int sum2 = Math.abs ( max1 + max2 );
        return Math.max ( sum1, sum2);
    }
}
