package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String line = scan.nextLine();

        List<Birthable> entitiesWithBirthday = new ArrayList<>();
        List<String> matchingBirthdays = new ArrayList<>();

        while(!line.equals("End")){
            String[] entityData = line.split("\\s+");

            String type = entityData[0];

            switch (type) {
                case "Citizen": {
                    String citizenName = entityData[1];
                    int citizenAge = Integer.parseInt(entityData[2]);
                    String id = entityData[3];
                    String citizenBirthDay = entityData[4];
                    entitiesWithBirthday.add(new Citizen(citizenName, citizenAge, id, citizenBirthDay));
                    break;
                }
                case "Pet": {
                    String petName = entityData[1];
                    String petBirthDay = entityData[2];
                    entitiesWithBirthday.add(new Pet(petName, petBirthDay));
                    break;
                }
                case "Robot": {
                    String robotModel = entityData[1];
                    String robotId = entityData[2];
                    break;
                }
            }

            line = scan.nextLine();
        }

        String searchedYear = scan.nextLine();

        filterAllByBirthayQuery(entitiesWithBirthday, matchingBirthdays, searchedYear);

        printOutput(matchingBirthdays);
    }

    private static void printOutput(List<String> matchingBirthdays) {
        if(matchingBirthdays.size() > 0) {
            System.out.println(String.join(System.lineSeparator(), matchingBirthdays));
        } else{
            System.out.println("<no output>");
        }
    }

    private static void filterAllByBirthayQuery(List<Birthable> entitiesWithBirthday, List<String> matchingBirthdays, String searchedYear) {
        Predicate<Birthable> isBornInGivenYear = x -> x.getBirthDate().endsWith(searchedYear);

        entitiesWithBirthday.stream()
                .filter(isBornInGivenYear)
                .forEach(x -> matchingBirthdays.add(x.getBirthDate()));
    }
}
