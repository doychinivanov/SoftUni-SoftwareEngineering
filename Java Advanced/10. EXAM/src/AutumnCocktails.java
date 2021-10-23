import java.util.*;
import java.util.function.Consumer;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, String> combinations = createCombinations();
        TreeMap<String, Integer> orders = createMenu();

        populateDeck(scan, queue, "queue");
        populateDeck(scan, stack, "stack");

        while(!queue.isEmpty() && !stack.isEmpty()){
            int queueValue = queue.poll();
            int stackValue = stack.pop();

            if(queueValue == 0){
                continue;
            }

            int combination = queueValue * stackValue;

            if(combinations.containsKey(combination)){
                String createdCocktail = combinations.get(combination);
                orders.put(createdCocktail, orders.get(createdCocktail) + 1);
            } else {
                queue.offer(queueValue + 5);
            }

        }

        if(allCocktailsAreDone(orders)){
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        Consumer<ArrayDeque<Integer>> createOutputForItems = (deck) -> {
            if(!deck.isEmpty()){
                List<Integer> leftItems = new ArrayList<>(deck);

                System.out.printf("Ingredients left: %d%n", leftItems.stream().mapToInt(x->x).sum());
            }
        };

        createOutputForItems.accept(queue);
        printMenu(orders);
    }

    private static Boolean allCocktailsAreDone(Map<String, Integer> menu){
        boolean allIsCooked = true;

        Set<Map.Entry<String, Integer>> entries = menu.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == 0) {
                allIsCooked = false;

                break;
            }
        }

        return allIsCooked;
    }

    private static int getNonZeroValue(ArrayDeque<Integer> deck, String type){
        int result;

        if(type.equals("stack")){
            result = deck.pop();

            while(result == 0 && !deck.isEmpty()){
                result = deck.pop();
            }
        } else {
            result = deck.poll();

            while(result == 0 && !deck.isEmpty()){
                result = deck.poll();
            }
        }

        return result;
    }

    private static void printMenu(Map<String, Integer> menu) {
        menu
                .forEach((item, count) -> {
                    if(count > 0){
                        System.out.printf(" # %s --> %d" + System.lineSeparator(), item, count);
                    }
                });
    }

    private static TreeMap<String, Integer> createMenu(){
        TreeMap<String, Integer> menu = new TreeMap<>();

        menu.put("Pear Sour", 0);
        menu.put("The Harvest", 0);
        menu.put("Apple Hinny", 0);
        menu.put("High Fashion", 0);

        return menu;
    }

    private static Map<Integer, String> createCombinations(){
        Map<Integer, String> combinations = new HashMap<>();

        combinations.put(150, "Pear Sour");
        combinations.put(250, "The Harvest");
        combinations.put(300, "Apple Hinny");
        combinations.put(400, "High Fashion");

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
}
