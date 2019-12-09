package corejava.lambda_expressions;

public class ClosuresExample {
    public static void main(String[] args){
        int a= 10;
        int b = 20;
//        doProcess(a, new Process() {
//            @Override
//            public void process(int i) {
//                System.out.println(i+b);
//            }
//        });

        doProcess(a, i-> System.out.println(i+b));
    }

    public static void doProcess(int i , Process p){
        p.process(i);
    }
}

interface Process{
    void process(int i);
}
