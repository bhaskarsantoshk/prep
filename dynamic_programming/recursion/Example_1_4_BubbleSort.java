package dynamic_programming.recursion;

public class Example_1_4_BubbleSort {
    public void bubbleSort ( int[] a, int n){
        for ( int i=0; i< n-1; i++){
            for ( int j=0; j<n-i-1; j++){
                if ( a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void bubbleSortRec( int a[], int n){
        if ( n == 0){
            return;
        }
        for ( int j=0; j< n-1; j++){
            if ( a[j] > a[j+1]){
                swap(a, j, j+1);
            }
        }
        bubbleSort(a, n-1);
    }
}
