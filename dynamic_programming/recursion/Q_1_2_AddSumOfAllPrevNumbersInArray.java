package dynamic_programming.recursion;

import utils.Utils;

public class Q_1_2_AddSumOfAllPrevNumbersInArray {
    public static void updateArray( int[] a){
        updateArray(a, 0);
    }

    private static void updateArray(int[] a, int index) {
        if ( index == a.length){
            return;
        }
        if ( index > 0) {
            a[index] += a[index - 1];
        }
        updateArray(a, index+1);
    }

    //Non Rec
    public static void updateArrayIterative( int[] a){
        for ( int i=1; i<a.length; i++){
            a[i]+=a[i-1];
        }
    }

    public static void main(String[] args){
        int a[]= {1,2,3,4,5,6};
        updateArray(a);
        Utils utils = new Utils();
        utils.print(a);
    }
}
