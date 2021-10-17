import java.util.*;
import java.util.function.BiFunction;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Map<String, Integer> menu = createMenu();
        Map<Integer, String> combinations = createCombinations();

        populateDeck(scan, liquids, "queue");
        populateDeck(scan, ingredients, "stack");

        while(!liquids.isEmpty() && !ingredients.isEmpty()){
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();

            int combination = currentIngredient + currentLiquid;

            if(combinations.containsKey(combination)){
                String createdItem = combinations.get(combination);
                menu.put(createdItem, menu.get(createdItem) + 1);
            } else {
                ingredients.push(currentIngredient + 3);
            }
        }

        if(allFoodIsCooked(menu)){
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        BiFunction<ArrayDeque<Integer>, String, String> createOutputForItems = (deck, type) -> {
            StringBuilder result = new StringBuilder();

            if(deck.isEmpty()){
                result.append(type).append(" left: none");
            } else {
                List<String> leftItems = new ArrayList<>();

                deck.forEach(x -> leftItems.add(String.valueOf(x)));

                result.append(String.format(type + " left: %s", String.join(", ", leftItems)));
            }

            return result.toString();
        };

        System.out.println(createOutputForItems.apply(liquids, "Liquids"));
        System.out.println(createOutputForItems.apply(ingredients, "Ingredients"));
        printMenu(menu);


    }

    private static Boolean allFoodIsCooked(Map<String, Integer> menu){
        Boolean allIsCooked = true;

        Set<Map.Entry<String, Integer>> entries = menu.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == 0) {
                allIsCooked = false;

                break;
            }
        }

        return allIsCooked;
    }

    private static void printMenu(Map<String, Integer> menu) {
        menu.forEach((item, count) -> System.out.printf("%s: %d" + System.lineSeparator(), item, count));
    }

    private static Map<Integer, String> createCombinations(){
       Map<Integer, String> combinations = new HashMap<>();

       combinations.put(25, "Biscuit");
       combinations.put(50, "Cake");
       combinations.put(75, "Pastry");
       combinations.put(100, "Pie");

       return combinations;
    }

    private static void populateDeck(Scanner scan, ArrayDeque<Integer> ingredients, String typeOfDeck) {
        int[] ingredientData = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if(typeOfDeck.equals("queue")){
            for (int n: ingredientData) {
                ingredients.offer(n);
            }
        } else {
            for (int n: ingredientData) {
                ingredients.push(n);
            }
        }

    }

    private static Map<String, Integer> createMenu(){
        Map<String, Integer> menu = new LinkedHashMap<>();

        menu.put("Biscuit", 0);
        menu.put("Cake", 0);
        menu.put("Pie", 0);
        menu.put("Pastry", 0);

        return menu;
    }
}
