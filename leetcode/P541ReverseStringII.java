package leetcode;

public class P541ReverseStringII {
    public String reverseStr(String s, int k) {
        char [] a = s.toCharArray();
        int index = 0;
        int last = s.length()-1;

        while ( last-index >= k){
            reverse(a, index, index+k);
            index +=2 *k;
        }
        if ( last -index > 0 && last - index < k){
            reverse(a, index, last);
        }
        return new String(a);
    }

    private void reverse(char[] a, int start, int end) {
        while  ( start < end){
            char temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }
}
