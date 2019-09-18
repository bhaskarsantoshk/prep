package amazon.binarysearch;

public class SquareRootofInteger {
    public int sqrt(int a) {
        int low = 1;
        int high = a;
        while ( low < high ){
            int mid = low + (high-low+1)/2;
            if ( mid == a/mid){
                return mid;
            }
            else if ( mid > a/mid){
                high = mid -1;
            }
            else{
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args){
        SquareRootofInteger obj = new SquareRootofInteger();
        System.out.println(obj.sqrt(Integer.MAX_VALUE));
    }
}
