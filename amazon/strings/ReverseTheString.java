package amazon.strings;

public class ReverseTheString {
    public String solve(String A) {
        char c[] = A.toCharArray();
        reverse(c, 0, c.length-1);
        reverseWords(c, c.length);
       return cleanUpSpaces(c, c.length);
    }

    private String cleanUpSpaces(char[] c, int length) {
        int i=0, j=0;
        while ( j < length){
            while ( j < length && c[j] == ' '){
                j++;
            }
            while ( j < length && c[j] != ' '){
                c[i++] = c[j++];
            }
            while ( j < length && c[j] == ' '){
                j++;
            }
            if ( j < length){
                c[i++] = ' ';
            }
        }
        return  new String(c).substring(0, i);
    }

    private void reverseWords(char[] c, int length) {
        int i=0, j=0;
        while ( i < length){
            //spaces
            while ( i < j || (i < length && c[i] == ' ')){
                i++;
            }
            while ( j < i || ( j< length && c[j] != ' ')){
                j++;
            }
            reverse(c, i, j-1);
        }
    }

    private void reverse(char[] c, int start, int end) {
        while ( start < end ){
            char temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }
    }
}
