import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCount = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        populateContinentsWithCountriesAndCities(scan, inputCount, continents);

        printContinentsWithCountriesAndCities(continents);
    }

    private static void printContinentsWithCountriesAndCities(LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents) {
        continents.forEach((continent, countries) -> {
            System.out.println(continent + ":");

            countries.forEach((country, cities) -> {
                System.out.printf("  %s -> %s" + System.lineSeparator(), country, String.join(", ", cities));
            });
        });
    }

    private static void populateContinentsWithCountriesAndCities(Scanner scan, int inputCount, LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents) {
        for (int i = 0; i < inputCount; i++) {
            String[] data = parseData(scan.nextLine(), "\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }
    }

    public static String[] parseData(String input, String delimiter){
        return input.split(delimiter);
    }
}
