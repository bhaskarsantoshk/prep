package random;

import java.util.ArrayList;
import java.util.List;

public class EfficientHarvest {
    public static long maxProfit(int k, List<Integer> profit) {
        int len = profit.size();
        System.out.println(profit);
        int temp[] = new int[len/2];
        for ( int i=0; i<temp.length; i++){
            temp[i] = profit.get(i) + profit.get(i+len/2);
        }
        for ( int i=0; i<temp.length; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
        return longestSubArrayOfLengthK(temp, k);
    }

    private static long longestSubArrayOfLengthK(int[] temp, int k) {
        long localSum = temp[0];
        long globalSum = temp[0];
        for ( int i=1; i<k; i++){
            localSum+= temp[i];
        }
        globalSum = Math.max(localSum, globalSum);
        int index = 0;
        for ( int i=k; i<temp.length; i++){
            localSum-= temp[index];
            index++;
            localSum+= temp[i];
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }

    private static void reverse(List<Integer> profit, int start, int end) {
        while ( start < end ){
            int temp = profit.get(start);
            profit.set(start++, profit.get(end));
            profit.set(end--, temp);
        }
    }

    public static void main(String[] args){
        int a[] = {-2,5,3,-1, -8,7,6, 1};
        List<Integer> list = new ArrayList<Integer>();
        for ( int x: a){
            list.add(x);
        }
       System.out.println( maxProfit(2, list));
    }

}
