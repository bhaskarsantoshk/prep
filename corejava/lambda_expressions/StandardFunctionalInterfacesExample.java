package corejava.lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfacesExample {
    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("bruce", "wayne", 26)
                , new Person("clark", "kent", 25),
                new Person ("diana", "prince", 5000));
        // Sort list by last name

        Collections.sort(people, (p1, p2)-> p1.getLastName().compareTo(p2.getLastName()));
        // Create a method that prints all elements in the list
        performConditionally(people, p-> true, p-> System.out.println(p));

        // Create a method that prints all people whose last name ends with e

        performConditionally(people, p-> p.getLastName().endsWith("e"), p-> System.out.println(p.getLastName()));
    }

    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for ( Person p: people){
            if ( predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

    private static void printLastNameEndsInE(List<Person> people) {
        for ( Person p: people){
            if ( p.getLastName().endsWith("e")) {
                System.out.println(p);
            }

        }
    }
}
