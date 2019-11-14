package parallel_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static parallel_programming.ReciprocalArraySum.printResults;

public class JavaStreamsDemo {

    public static double seqIteration(Student[] studentArray){
        long startTime = System.nanoTime();
        List<Student> activeStudents = new ArrayList<>();
        for ( Student s : studentArray){
            if ( s.isCurrent ){
                activeStudents.add(s);
            }
        }

        long ageSum = 0;
        for ( Student a: activeStudents){
            ageSum+= a.age;
        }

        double result = (double) ageSum/ (double) activeStudents.size();

        long timeInNanos = System.nanoTime() - startTime;

        printResults("seqIteration", timeInNanos, result);
        return result;
    }


    public static double parStream(Student[] students){
        long startTime = System.nanoTime();
        List<Student> activeStudents = new ArrayList<>();

    double result = Stream.of(students)
                    .parallel()
                    .filter(student -> student.isCurrent)
                    .mapToDouble(a-> a.age)
                    .average()
                    .getAsDouble();

        long timeInNanos = System.nanoTime() - startTime;

        printResults("seqIteration", timeInNanos, result);
        return result;
    }
    
    class Student{

        public boolean isCurrent;
        public long age;
    }
}
