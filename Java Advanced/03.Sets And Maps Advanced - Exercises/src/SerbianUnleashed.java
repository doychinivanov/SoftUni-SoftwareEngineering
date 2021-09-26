import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SerbianUnleashed {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> concerts = new LinkedHashMap<>();

        String input = scan.nextLine();

        while(!input.equals("End")){
            List<String> concertData = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

            String name;
            int ticketCount;
            int ticketPrice;
            String city;

            if(concertData.size() < 4){
                input = scan.nextLine();
                continue;
            }

            try{
                name = getName(concertData);
                ticketCount = Integer.parseInt(concertData.remove(concertData.size() -1));
                ticketPrice = Integer.parseInt(concertData.remove(concertData.size() -1));
                city = getCity(concertData);
            } catch (Exception e){
                input = scan.nextLine();
                continue;
            }

            populateConcerts(concerts, name, ticketCount, (long) ticketPrice, city);


            input = scan.nextLine();
        }

        printConcertsSortedByRevenue(concerts);
    }

    private static void printConcertsSortedByRevenue(LinkedHashMap<String, LinkedHashMap<String, Long>> concerts) {
        concerts.forEach((city, event) -> {
            System.out.println(city);

            event
                    .entrySet()
                    .stream()
                    .sorted((ev1, ev2) -> ev2.getValue().compareTo(ev1.getValue()))
                    .forEach(ev -> System.out.printf("#  %s -> %d" + System.lineSeparator(), ev.getKey(), ev.getValue()));
        });
    }

    private static void populateConcerts(LinkedHashMap<String, LinkedHashMap<String, Long>> concerts, String name, int ticketCount, long ticketPrice, String city) {
        concerts.putIfAbsent(city, new LinkedHashMap<>());
        LinkedHashMap<String, Long> cityConcerts = concerts.get(city);
        cityConcerts.putIfAbsent(name, 0L);
        cityConcerts.put(name, cityConcerts.get(name) + ticketPrice * ticketCount);
    }

    private static String getCity(List<String> concertData) throws Exception {
        if(concertData.get(0).startsWith("@")){
            return String.join(" ", concertData).substring(1);
        } else {
            throw new Exception();
        }
    }

    private static String getName(List<String> concertData) {
        StringBuilder name = new StringBuilder();
        while(!concertData.get(0).startsWith("@")){
            name.append(concertData.get(0)).append(" ");

            concertData.remove(0);
        }

        return name.substring(0, name.length()-1);
    }
}
