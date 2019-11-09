package ctci.C16moderate;

public class NumberSwappers {
    static int a = 10, b= 15;
    public static void main(String [] args){
      swap(a, b);
    }

    public static void swap(int a, int b){
        System.out.println(a+" "+ b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+" "+ b);
    }


}
