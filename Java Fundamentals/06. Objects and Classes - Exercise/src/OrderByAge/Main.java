package OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> peopleStorage = new ArrayList<>();
        String input = scan.nextLine();

        while(input.equals("End") == false){
            String[] userData = input.split("\\s+");
            String name = userData[0];
            int ID = Integer.parseInt(userData[1]);
            int age = Integer.parseInt(userData[2]);

            peopleStorage.add(new Person(name, ID, age));

            input = scan.nextLine();
        }

        peopleStorage.sort(Comparator.comparing(Person::getAge));

        System.out.println(printElements(peopleStorage));
    }

    public static String printElements(List<Person> people){
        String result = "";

        for (Person person: people) {
            result += String.format("%s with ID: %d is %d years old.\n", person.getName(), person.getID(), person.getAge());
        }

        return  result;
    }
}
