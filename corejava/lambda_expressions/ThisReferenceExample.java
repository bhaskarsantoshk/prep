package corejava.lambda_expressions;

public class ThisReferenceExample {
    public void doProcess( int i, Process p){
        p.process(i);
    }

    public static void main(String[] args){
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
//        thisReferenceExample.doProcess(10, new Process() {
//            @Override
//            public void process(int i) {
//                System.out.println("Value of i is "+ i);
//                System.out.println(this);
//            }
//
//            public String toString(){
//                return "This is an anonymous inner class";
//            }
//        });
        thisReferenceExample.doProcess(10, i-> {
            //System.out.println(this); // gives an error

        });

        thisReferenceExample.execute();
    }

    public void execute(){
        // this - refers to instance of obj on which execute method is called
        doProcess(10, i-> {
            System.out.println("Value of i "+ i);
            System.out.println(this); // this will work as this is not a static context
        });
    }
}
