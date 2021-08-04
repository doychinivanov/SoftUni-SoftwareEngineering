import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> towns = new LinkedHashMap<>();
        String input = scan.nextLine();

        input = setTowns(input, towns, scan);

        input = scan.nextLine();

        townActions(input, towns, scan);

        if(towns.entrySet().size() > 0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", towns.entrySet().size());

            towns
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted((a,b) -> b.getValue().get(1) - a.getValue().get(1))
                    .forEach(town -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", town.getKey(), town.getValue().get(0), town.getValue().get(1)));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }

    public static String setTowns(String input, Map<String, List<Integer>> towns, Scanner scan){
        while(!input.equals("Sail")) {
            String[] inputData = input.split("\\|\\|");
            String townName = inputData[0];
            int population = Integer.parseInt(inputData[1]);
            int gold = Integer.parseInt(inputData[2]);

            towns.putIfAbsent(townName, new ArrayList<>());
            List<Integer> currentCityData = towns.get(townName);

            if (currentCityData.size() > 0) {
                currentCityData.set(0, currentCityData.get(0) + population);
                currentCityData.set(1, currentCityData.get(1) + gold);
            } else {
                currentCityData.add(population);
                currentCityData.add(gold);
            }

            input = scan.nextLine();
        }
        return input;
    }

    public static void townActions(String input, Map<String, List<Integer>> towns, Scanner scan){
        while(!input.equals("End")){
            String[] data = input.split("=>");
            String command = data[0];
            String townName = data[1];
            List<Integer> currentTownData = towns.get(townName);

            if(command.equals("Plunder")){
                int killedPeople = Integer.parseInt(data[2]);
                int stolenGold = Integer.parseInt(data[3]);


                int currentPopulation = currentTownData.get(0);
                int currentGold = currentTownData.get(1);

                currentTownData.set(0, currentPopulation - killedPeople);
                currentTownData.set(1, currentGold - stolenGold);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", townName, stolenGold, killedPeople);

                if(currentTownData.get(0) <= 0 || currentTownData.get(1) <=0){
                    towns.remove(townName);
                    System.out.printf("%s has been wiped off the map!\n", townName);
                }
            } else if(command.equals("Prosper")){
                int addedGold = Integer.parseInt(data[2]);

                if(addedGold <= 0){
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    currentTownData.set(1, currentTownData.get(1) + addedGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", addedGold, townName, currentTownData.get(1));
                }
            }

            input = scan.nextLine();
        }
    }
}
