package random;

import java.util.*;

public class MaxPeopleAlive {

    public static class Person{
        int birthYear;
        int deathYear;
        public Person(int birthYear, int deathYear){
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }
    }

    public static void main(String[] args)
    {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person(1982, 2017);
        Person p2 = new Person(1923, 2004);
        Person p3 = new Person(1988, 2015);
        Person p4 = new Person(1910, 1988);
        Person p5 = new Person(1990, 2005);
        Person p6 = new Person(2004, 2010);
        Collections.addAll(people, p1, p2, p3, p4, p5, p6);
        System.out.println(new MaxPeopleAlive().findYears(people));


}

    private int findYears(List<Person> people) {
        Map<Integer, Integer> years = new TreeMap<>();
        for ( Person person: people){
            years.put(person.birthYear, years.getOrDefault(person.birthYear, 0)+1);
            years.put(person.deathYear+1, years.getOrDefault(person.deathYear+1, 0)-1);
        }
        int maxYear = 0, max = Integer.MIN_VALUE, cur = 0;

        for ( Map.Entry<Integer, Integer> entry: years.entrySet()){
            int year = entry.getKey();
            int population = entry.getValue();
            cur+= population;
            if ( cur > max){
                max = cur;
                maxYear = year;
            }
        }
        return maxYear;
    }
    }
