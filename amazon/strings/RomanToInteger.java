package amazon.strings;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String A) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        for ( int i=0; i<A.length()-1; i++){
            if ( map.get(A.charAt(i)) >= map.get(A.charAt(i+1))) {
                sum += map.get(A.charAt(i));

            }
            else{
                sum -= map.get(A.charAt(i));
            }
        }
        sum += map.get(A.charAt(A.length()-1));
        return sum;
    }

    public static void main(String[] args){
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("MDCCCIV"));
    }
}
