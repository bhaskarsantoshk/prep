package corejava.lambda_expressions;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("bruce", "wayne", 26)
                , new Person("clark", "kent", 25),
                new Person("diana", "prince", 5000));

        // external iterator
        System.out.println("For loop");
        for ( int i=0; i<people.size(); i++){
            System.out.println(people.get(i).getLastName());
        }

        System.out.println("For in loop");
        for ( Person p: people){
            System.out.println(p.getLastName());
        }

        // Internal iterator- iteration control is up to JVM
        System.out.println("For each loop");
        people.forEach(p-> System.out.println(p.getLastName())); // Parallel
    }
}
