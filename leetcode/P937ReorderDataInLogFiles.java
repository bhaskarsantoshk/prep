package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P937ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                int s1Index = s1.indexOf(' ');
                int s2Index = s2.indexOf(' ');

                char s1Char = s1.charAt(s1Index+1);
                char s2Char = s2.charAt(s2Index+1);

                if ( s1Char <= '9'){
                    if ( s2Char <= '9'){
                        return 0;
                    }
                    return 1;
                }
                if ( s2Char <= '9'){
                    return -1;
                }

                int preCompute = s1.substring(s1Index+1).compareTo(s2.substring(s2Index+1));
                if ( preCompute == 0){
                    return s1.substring(0, s1Index).compareTo(s2.substring(0, s2Index));
                }
                return preCompute;
        }
        };
        Arrays.sort(logs, myComparator);
        return logs;
    }
}
