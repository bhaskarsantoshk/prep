package amazon.bitmanipulation;

public class DivideIntegers {
    public int divide(int a, int b) {
        if ( a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        int result = 0;
        int A = Math.abs(a);
        int B = Math.abs(b);
        while ( A - B >= 0){
            int x = 0;
            while ( A - ( B << 1 << x) >=0 ){
                x++;
            }
            result+= ( 1 << x);
            A = A - (B << x);
        }
        int sign =  (( a >=0 && b >=0) || ( a <=0 && b <=0 )) ? 1: -1;
        return result * sign;
    }

    public static void main(String[] args){
        DivideIntegers obj = new DivideIntegers();
        System.out.println(obj.divide(-2147483648,-1));
        System.out.println(Integer.MIN_VALUE);
    }
}
