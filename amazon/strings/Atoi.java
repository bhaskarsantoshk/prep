package amazon.strings;

public class Atoi {
    public int atoi(final String A) {
        int index = 0;
        int sign = 1;
        int total = 0;

        // empty string
        if ( A.length() == 0 ){
            return 0;
        }
        // assume all spaces
        while ( index < A.length() && A.charAt(index) == ' '){
            index++;
        }
        if (index == A.length()){
            return 0;
        }

        // Decide sign
        if ( A.charAt(index) == '+' || A.charAt(index) == '-'){
            sign = A.charAt(index) == '+' ? 1: -1;
            index++;
        }

        while ( index < A.length() ){
            int digit = A.charAt(index) - '0';
            if ( !isDigit(digit)){
                break;
            }
            if ( isOverFlow (total, digit)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total*10 + digit;
            index++;
        }
        return total * sign;
    }

    private boolean isOverFlow(int total, int digit) {
        if ( total > Integer.MAX_VALUE/10 || ( total == Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE % 10)){
            return true;
        }
        return false;
    }

    private boolean isDigit(int digit) {
        return digit>=0 && digit<=9;
    }
}
