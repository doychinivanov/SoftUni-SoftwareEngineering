package Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Person> people = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            String type = tokens[1];

            people.putIfAbsent(personName, new Person(personName));

            if(type.equals("company")){
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);

                people.get(personName).setCompany(new Company(companyName, department, salary));

            } else if(type.equals("car")){
                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);

                people.get(personName).setCar(new Car(carModel, carSpeed));
            } else if(type.equals("pokemon")){
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];

                people.get(personName).getPokemons().add(new Pokemon(pokemonName, pokemonType));
            } else if(type.equals("children")){
                String childName = tokens[2];
                String childBirthday = tokens[3];

                people.get(personName).getChildren().add(new Child(childName, childBirthday));
            } else if (type.equals("parents")){
                String parentName = tokens[2];
                String parentBirthday = tokens[3];

                people.get(personName).getParents().add(new Parent(parentName, parentBirthday));
            }

            input = scan.nextLine();
        }

        String personToFind = scan.nextLine();

        System.out.println(people.get(personToFind));
    }
}
