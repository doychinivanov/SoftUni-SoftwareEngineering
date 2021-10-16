package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scan.nextLine();

        while (!input.equals("END")){

            String[] personData = input.split("\\s+");

            people.add(new Person(personData[0], Integer.parseInt(personData[1]), personData[2]));

            input = scan.nextLine();
        }

        int indexToFind = Integer.parseInt(scan.nextLine()) - 1;
        Person personToCompareWith = people.get(indexToFind);

        int matchingPeople = (int) people.stream().filter(person -> personToCompareWith.compareTo(person) == 0).count();

        if(matchingPeople > 0 && matchingPeople != 1){
            System.out.printf("%d %d %d", matchingPeople, people.size() - matchingPeople, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
