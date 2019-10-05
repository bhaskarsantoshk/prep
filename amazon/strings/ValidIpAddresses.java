package amazon.strings;

import java.util.ArrayList;

public class ValidIpAddresses {
    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> result = new ArrayList<>();
        int len = A.length();
        for ( int i=1 ; i<len && i<4; i++){
            String first = A.substring(0, i);
            if ( !isValidPart(first)){
                continue;
            }
            for ( int j = 1; i+j < len && j<4; j++ ){
                String second = A.substring(i, i+j);
                if ( !isValidPart(second)){
                    continue;
                }
                for ( int k =1; i+j+k < len && k<4; k++){
                    String third = A.substring(i+j, i+j+k);
                    String fourth = A.substring(i+j+k);
                    if ( !isValidPart(third) || !isValidPart(fourth)){
                        continue;
                    }
                    result.add(first+"."+second+"."+third+"."+fourth);
                }
            }
        }
        return result;
    }
    private boolean isValidPart(String s ){
        if ( s.length() > 3 ){
            return false;
        }
        // 0 is valid , 00, 001,01, etc. aren't
        if (s.startsWith("0")&& s.length() >1){
            return false;
        }
        int val = Integer.parseInt(s);
        return val>=0 && val<=255;
    }


}
