package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> peopleStorage = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personData = scan.nextLine().split("\\s+");

            Person newPerson = new Person(personData[0], Integer.parseInt(personData[1]));
            peopleStorage.add(newPerson);
        }

        List<Person> peopleOverThirty = peopleStorage
                .stream()
                .filter(peron -> peron.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        System.out.println(printElements(peopleOverThirty));
    }

    public static String printElements(List<Person> people){
        String result = "";

        for (Person person: people) {
            result += person.getName() + " - " + person.getAge() + '\n';
        }

        return result;
    }
}
