import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulateCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryWithCities = new LinkedHashMap<>();


        String input = scan.nextLine();

        while(!input.equals("report")){
            String[] countryData = input.split("\\|");

            String city = countryData[0];
            String country = countryData[1];
            long cityPopulation = Long.parseLong(countryData[2]);

            populateCountry(countryPopulation, country, cityPopulation);

            populateCountriesCities(countryWithCities, city, country, cityPopulation);

            input = scan.nextLine();
        }

        countryWithCities
                .entrySet()
                .stream()
                .sorted((c1, c2) -> countryPopulation.get(c2.getKey()).compareTo(countryPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)\n",country.getKey(),countryPopulation.get(country.getKey()));

                    country.getValue().entrySet()
                            .stream()
                            .sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city ->{
                        System.out.format("=>%s: %d\n", city.getKey(),city.getValue());
                    });
                });
    }


    private static void populateCountriesCities(LinkedHashMap<String, LinkedHashMap<String, Long>> countryWithCities, String city, String country, long cityPopulation) {
        countryWithCities.putIfAbsent(country, new LinkedHashMap<>());
        LinkedHashMap<String, Long> currentCity = countryWithCities.get(country);
        currentCity.putIfAbsent(city, 0L);
        currentCity.put(city, currentCity.get(city) + cityPopulation);
    }

    private static void populateCountry(LinkedHashMap<String, Long> countryPopulation, String country, long cityPopulation) {
        countryPopulation.putIfAbsent(country, 0L);
        countryPopulation.put(country, countryPopulation.get(country) + cityPopulation);
    }
}
