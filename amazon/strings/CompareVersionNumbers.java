package amazon.strings;

import java.math.BigInteger;

public class CompareVersionNumbers {
    public int compareVersion(String A, String B) {
       String[] a = A.split("\\.");
       String[] b = B.split("\\.");
       int i=0;
       while ( i < a.length || i < b.length ){
           if ( i < a.length && i < b.length ){
               BigInteger x = new BigInteger(a[i]);
               BigInteger y = new BigInteger(b[i]);
               if ( x.compareTo(y) == 1 ){
                   return 1;
               }
               else if ( x.compareTo(y)  == -1){
                   return -1;
               }
           }
           else if ( i < a.length){
               BigInteger x = new BigInteger(a[i]);
               if ( x.compareTo(new BigInteger("0")) != 0){
                   return 1 ;
               }
           }
           else if ( i < b.length ){
               BigInteger x = new BigInteger(a[i]);
               if ( x.compareTo(new BigInteger("0")) != 0){
                   return -1 ;
               }
           }
           i++;
       }
       return 0;
    }
}
