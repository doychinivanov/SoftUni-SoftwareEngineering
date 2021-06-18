import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays
                .stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (input.equals("Yohoho!") == false){
            List<String> inputData = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());;
            String command = inputData.get(0);
            inputData.remove(0);

            if(command.equals("Loot")){
                items.addAll(0, loot(inputData, items));
            } else if(command.equals("Drop")){
                drop(Integer.parseInt(inputData.get(0)), items);
            } else if(command.equals("Steal")){
                steal(Integer.parseInt(inputData.get(0)), items);
            }

            input= scan.nextLine();
        }

        if(items.isEmpty() == false){
            System.out.printf("Average treasure gain: %.2f pirate credits.", countPoints(items)/items.size());
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }

    public static List loot(List<String> newList, List<String> baseList){
        List<String> tempList = new ArrayList<>();

        for (String item: newList) {
            if(baseList.contains(item) == false){
                tempList.add(item);
            }
        }

        Collections.reverse(tempList);
        return tempList;
    }

    public static void drop(int index, List<String> items){
        if(index < 0 || index >= items.size()){
            return;
        }

        String tempItem = items.get(index);
        items.remove(index);
        items.add(tempItem);
    }

    public static void steal(int count, List<String> items){
        int startToCut = items.size() - count;
        List<String> stolenItems = new ArrayList<>();

        if(startToCut < 0){
            startToCut = 0;
        }

        for (int i = startToCut; i < items.size(); i++) {
            String stolenObject = items.get(i);
            items.remove(i);
            stolenItems.add(stolenObject);
            i--;
        }

        System.out.println(String.join(", ", stolenItems));
    }

    public static double countPoints(List<String> items){
        double totalScore = 0;

        for (String item: items) {
            totalScore += item.length();
        }

        return totalScore;
    }
}
