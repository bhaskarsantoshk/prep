package dynamic_programming.recursion;

public class Example_1_3_TowerOfHanoi {
    public void towerOfHanoi( char s, char d, char e, int n){
        if ( n <= 0 ) return;
        towerOfHanoi(s,e,d,n-1);
        System.out.println("Move Disk "+n+ " From "+s+" to "+d);
        towerOfHanoi(e, d, s, n-1);
    }
}
