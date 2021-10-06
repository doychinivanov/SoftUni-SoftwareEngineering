package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] personData = scan.nextLine().split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            people.add(new Person(name, age));
        }

        Predicate<Person> filterOlderThan30 = person -> person.getAge() > 30;
        Comparator<Person> filterPeopleByName = Comparator.comparing(Person::getName);

        people
                .stream()
                .filter(filterOlderThan30)
                .sorted(filterPeopleByName)
                .forEach(System.out::println);

    }
}
