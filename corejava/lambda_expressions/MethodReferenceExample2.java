package corejava.lambda_expressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("bruce", "wayne", 26)
                , new Person("clark", "kent", 25),
                new Person("diana", "prince", 5000));
        //performConditionally(people, p -> true, p -> System.out.println(p));
        performConditionally(people, p -> true, System.out::println);

    }

    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
