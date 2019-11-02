package standard_algorithms.graphs;

import utils.Utils;

public class MergeSort {
    public void mergeSort( int [] a, int start, int end){
        if ( start >= end ){
            return;
        }
        int mid = start + ( end - start) /2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);
        merge(a, start, mid, end);
    }

    private void merge(int[] Arr, int start, int mid, int end) {
        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1; i += 1;
            }
            else {
                temp[k] = Arr[j];
                k += 1; j += 1;
            }
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }

        // add elements left in the second interval
        while(j <= end) {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

    public static void main( String[] args){
        int a[] = { 2,4,1,6,7,9,0,8};
        MergeSort obj = new MergeSort();
        obj.mergeSort(a, 0, a.length-1);
        new Utils().print(a);
    }
}
