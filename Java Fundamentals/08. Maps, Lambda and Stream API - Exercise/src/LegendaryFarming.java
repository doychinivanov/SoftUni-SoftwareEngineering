import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> collectedResources = new TreeMap<>();
        Map<String, Integer> collectedJunk = new TreeMap<>();

        collectedResources.put("fragments", 0);
        collectedResources.put("shards", 0);
        collectedResources.put("motes", 0);

        String winner = "";

        while(winner.equals("")){
            String[] currentResources = scan.nextLine().split("\\s+");

            winner = populateReserves(collectedResources, collectedJunk, currentResources, winner);
        }

        printOutput(collectedResources, collectedJunk, winner);

    }

    public static String populateReserves(Map<String, Integer> recourses, Map<String, Integer> junk, String [] currentResources, String winner){
        for (int i = 0; i < currentResources.length -1; i++) {
            int quantity = Integer.parseInt(currentResources[i]);
            i++;
            String recourseType = currentResources[i].toLowerCase(Locale.ROOT);

            if(recourseType.equals("fragments") || recourseType.equals("shards") || recourseType.equals("motes")){
                recourses.put(recourseType, recourses.get(recourseType) + quantity);
                winner = findWinner(recourses, recourseType, winner);

                if(winner.equals("")==false){
                    break;
                }
            } else {
                junk.putIfAbsent(recourseType, 0);
                junk.put(recourseType, junk.get(recourseType) + quantity);
            }
        }

        return winner;
    }

    public static String findWinner(Map<String, Integer> recourses, String item, String winner){
        if(recourses.get(item) >= 250){
            switch (item){
                case "shards": winner = "Shadowmourne"; break;
                case "fragments": winner = "Valanyr"; break;
                case "motes": winner = "Dragonwrath"; break;
                default: break;
            }

            recourses.put(item, recourses.get(item) - 250);
        }

        return winner;
    }

    public static void printOutput(Map<String, Integer>collectedResources, Map<String, Integer> collectedJunk, String winner){
        System.out.printf("%s obtained!\n", winner);

        collectedResources
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));


        collectedJunk
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));
    }
}
