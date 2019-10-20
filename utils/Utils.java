package utils;

public class Utils {
    public void print(int[] a){
        System.out.println("Printing the array");
        for ( int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("\n"+"Done");
    }
}
