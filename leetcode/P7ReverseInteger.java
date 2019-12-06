package leetcode;

public class P7ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if ( x < 0){
            sign = -1;
            x = x * -1;
        }
        int result = 0;
        while ( x != 0 ){
            int rem = x % 10;
            int newResult = result * 10 + rem;
            if ( (newResult-rem)/ 10 != result ){
                return 0;
            }
            result = newResult;
            x/=10;
        }
        return result * sign;
    }
}
