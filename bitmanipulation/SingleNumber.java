package bitmanipulation;

import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for ( int num: A) {
            result ^= num;
        }
        return result;
    }
}
