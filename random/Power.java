package random;

public class Power {

    public double calculatePower(double x, int n){
        if ( n == 0){
            return 1;
        }
        if ( n == Integer.MIN_VALUE && x > 1){
            return 0;
        }
        if ( n < 0){
            n = -n;
            x = 1/x;
        }
        return n % 2 == 0 ? calculatePower(x*x, n/2) : x * calculatePower(x*x, n/2);
    }
}
