package foodShortage;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Buyer> people = new HashMap<>();

        int peoplesCount = Integer.parseInt(scan.nextLine());

        populatePeople(scan, people, peoplesCount);

        String personWhoBoughtFood = scan.nextLine();

        buyFoodForAllBuyers(scan, people, personWhoBoughtFood);

        int allBoughtFood = people.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(allBoughtFood);
    }

    private static void buyFoodForAllBuyers(Scanner scan, HashMap<String, Buyer> people, String personWhoBoughtFood) {
        while(!personWhoBoughtFood.equals("End")){

            if(people.containsKey(personWhoBoughtFood)){
                Buyer currentPerson = people.get(personWhoBoughtFood);

                currentPerson.buyFood();
            }

            personWhoBoughtFood = scan.nextLine();
        }
    }

    private static void populatePeople(Scanner scan, HashMap<String, Buyer> people, int peoplesCount) {
        for (int i = 0; i < peoplesCount; i++) {
            String[] personData = scan.nextLine().split("\\s+");

            String personName = personData[0];
            int personAge = Integer.parseInt(personData[1]);

            if(personData.length == 4) {
                String personId = personData[2];
                String personBirthDay = personData[3];

                people.put(personName, new Citizen(personName, personAge, personId, personBirthDay));
            } else {
                String personGroup = personData[2];

                people.put(personName, new Rebel(personName, personAge, personGroup));

            }
        }
    }
}
