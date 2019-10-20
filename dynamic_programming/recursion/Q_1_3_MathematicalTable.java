package dynamic_programming.recursion;

public class Q_1_3_MathematicalTable {
    public void printTable ( int n){
        for ( int i=1; i<=10; i++){
            System.out.print(n+" * "+i+" = "+(n*i));
        }
    }

    public void printTableRec ( int n ){
        printTable(n, 1);
    }

    private void printTable(int n, int i) {
        if ( i > 10){
            return;
        }
        System.out.println(n+" * "+i+" = "+(n*i));
        printTable(n, i+1);
    }
    public static void main(String[] args){
        Q_1_3_MathematicalTable obj = new Q_1_3_MathematicalTable();
        obj.printTableRec(10);
    }
}
