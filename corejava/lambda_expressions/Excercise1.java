package corejava.lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Excercise1 {

    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("bruce", "wayne", 26)
                                            , new Person("clark", "kent", 25),
                                            new Person ("diana", "prince", 5000));
        // Sort list by last name

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        // Create a method that prints all elements in the list
        printAll(people);

        // Create a method that prints all people whose last name ends with e
        printLastNameEndsInE(people);

        printConditionally(people, new Condition(){

            @Override
            public boolean test(Person p) {
                return p.getLastName().endsWith("e");
            }
        });
    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for ( Person p: people){
            if ( condition.test(p)){
                System.out.println(p);
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

    private static void printAll(List<Person> people) {
        for ( Person p: people){
                System.out.println(p);
        }
    }
}

interface Condition{
    public boolean test(Person p);
}
