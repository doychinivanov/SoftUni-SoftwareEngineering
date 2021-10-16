package StrategyPattern;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<Person> peopleSortedByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> peopleSortedByAge = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] personData = scan.nextLine().split("\\s+");

            Person person = new Person(personData[0], Integer.parseInt(personData[1]));

            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }

        Consumer<Person> printPeople = person -> System.out.printf("%s %d" + System.lineSeparator(), person.getName(), person.getAge());
        
        peopleSortedByName.forEach(printPeople);
        peopleSortedByAge.forEach(printPeople);
    }
}
