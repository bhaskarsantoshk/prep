package amazon.math;

public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int result = 0;
        int multiplyer = 1;
        for ( int i=A.length()-1; i>=0; i--){
            result+= ( multiplyer * ( A.charAt(i)-'A'+1) );
            multiplyer*= 26;
        }
        return result;
    }
    public static void main(String[] args){
        ExcelColumnNumber obj = new ExcelColumnNumber();
        System.out.println(obj.titleToNumber("Z"));
    }
}
