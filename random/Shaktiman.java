package random;

import java.util.ArrayList;
import java.util.List;

public class Shaktiman {
    static int shaktimaan(List<Integer> power){
        int result = 0;
        int pi = 0;
        for ( int num: power){
            if ( num > 0){
                pi+= num;
            }
            else{
                if ( pi > Math.abs( num)){
                    pi -= (Math.abs(num));
                }
                else{
                    result+= Math.abs(pi+num)+1;
                    pi = 1;
                }

            }
            System.out.println(pi+" "+result);
        }
        return result;
    }

    public static void main(String[] args){
        int a[] = { 0,0,1,1,0};
        List<Integer> list = new ArrayList<>();
        for ( int num: a){
            list.add(num);
        }
        System.out.println(shaktimaan(list));
    }



}


