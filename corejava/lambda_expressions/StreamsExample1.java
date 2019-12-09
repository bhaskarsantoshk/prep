package corejava.lambda_expressions;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {
    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("bruce", "wayne", 26)
                , new Person("clark", "kent", 25),
                new Person("diana", "prince", 5000));

        people.stream().forEach(p-> System.out.println(p.getLastName()));
        people.stream().filter(p-> p.getLastName().endsWith("e")).forEach(p-> System.out.println(p.getLastName()));
    }
}
