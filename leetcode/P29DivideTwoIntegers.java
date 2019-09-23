package leetcode;

public class P29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if ( dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int result = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        while ( a-b >= 0){
            int x = 0;
            while ( a - ( b << 1 << x) >= 0){
                x++;
            }
            result+= ( 1 << x);
            a-= b<<x;
        }
        int sign = (( dividend>=0 && divisor>= 0) || (dividend<=0 && divisor<=0)) ? 1: -1;
        return result * sign;
    }
}
