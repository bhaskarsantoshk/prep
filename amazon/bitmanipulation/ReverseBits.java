package amazon.bitmanipulation;

public class ReverseBits {
    public long reverse(long a) {
        long res = 0;
        for ( int i=0; i<32 ; i++){
            if ( (a & 1) == 1) {
                res += 1;
            }
            a = a >> 1;
            res = res << 1;
        }
        return res >> 1;
    }
    public static void main(String[] args){
        ReverseBits obj = new ReverseBits();
        System.out.println(obj.reverse(2));
    }
}
