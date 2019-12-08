package corejava.lambda_expressions;

public class TypeInferenceExample {
    public static void main(String [] args){
        //StringLengthLambda myLamda = s-> s.length();
        //System.out.println(myLamda.getLength("Hello Lambda"));
        //System.out.println();
        printLambda(s->s.length());
    }

    interface StringLengthLambda{
        int getLength(String s);
    }

    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Hello World"));
    }
}
