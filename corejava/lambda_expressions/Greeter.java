package corejava.lambda_expressions;

public class Greeter {
    public void greet(){
        System.out.println("Hello World");
    }

    public void greet( Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args){
        Greeter greeter = new Greeter();
        Greeting helloWorldGreeting = new HelloWorldGreeting();

        Greeting lamdaGreeting = () -> System.out.println("Hello World");
        helloWorldGreeting.perform();
        //lamdaGreeting.perform();


        Greeting innerClass = new Greeting() {
            @Override
            public void perform() {
                System.out.println("HW");
            }
        };

        innerClass.perform();

        greeter.greet(lamdaGreeting);
        greeter.greet(innerClass);
    }
}

