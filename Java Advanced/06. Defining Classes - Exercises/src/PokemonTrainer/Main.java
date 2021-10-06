package PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        input = createTrainersWithCollections(scan, input, trainers);

        while (!input.equals("End")){
            String elementType = input;
            trainers.forEach((personName, person) -> {
                if(person.hasAtLeastOneOfCertainType(elementType)){
                    person.increaseBadges();
                } else {
                    person.getCollection().forEach(Pokemon::decreaseHealth);
                    person.filterDeathPokemons();
                }
            });

            input = scan.nextLine();
        }

        Comparator<Map.Entry<String, Trainer>> filterByBadges = (p1, p2) -> p2.getValue().getBadges() - p1.getValue().getBadges();
        trainers
                .entrySet()
                .stream()
                .sorted(filterByBadges)
                .forEach(entry -> System.out.println(entry.getValue().toString()));
    }

    private static String createTrainersWithCollections(Scanner scan, String input, LinkedHashMap<String, Trainer> trainers) {
        while(!input.equals("Tournament")){
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonType = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getCollection().add(new Pokemon(pokemonName, pokemonType, pokemonHealth));

            input = scan.nextLine();
        }

        input = scan.nextLine();
        return input;
    }
}
