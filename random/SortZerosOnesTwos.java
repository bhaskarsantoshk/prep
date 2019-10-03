package random;

public class SortZerosOnesTwos {
    private static void sort(int[] arr){
        int j=0, k=arr.length-1;
        for ( int index=0; index<=k; index++){
            if ( arr[index] == 0){
                swap(arr, index, j++);
            }
            else if ( arr[index] == 2){
                swap(arr, index--, k--);
            }
        }
    }

    private static  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int [] arr= { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort(arr);
        for ( int num: arr){
            System.out.print(num+" ");
        }
    }
}
