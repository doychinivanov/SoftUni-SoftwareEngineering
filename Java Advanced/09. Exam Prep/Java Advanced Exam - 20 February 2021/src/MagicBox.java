import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> collected = new ArrayList<>();

        populateDeck(scan, queue, "queue");
        populateDeck(scan, stack, "stack");

        while(!queue.isEmpty() && !stack.isEmpty()){
            int currentSum = queue.peek() + stack.peek();

            if(currentSum % 2 == 0){
                collected.add(currentSum);
                queue.poll();
                stack.pop();
            } else {
                queue.offer(stack.pop());
            }
        }

        printGeneralOutcome(queue);

        printScore(collected);

    }

    private static void printScore(List<Integer> collected) {
        int totalValueCollected = collected.stream().mapToInt(x->x).sum();

        if(totalValueCollected >= 90){
            System.out.println("Wow, your prey was epic! Value: " + totalValueCollected);
        } else {
            System.out.println("Poor prey... Value: " + totalValueCollected);
        }
    }

    private static void printGeneralOutcome(ArrayDeque<Integer> queue) {
        if(queue.isEmpty()){
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
    }

    private static void populateDeck(Scanner scan, ArrayDeque<Integer> deck, String typeOfDeck) {
        int[] ingredientData = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if(typeOfDeck.equals("queue")){
            for (int n: ingredientData) {
                deck.offer(n);
            }
        } else {
            for (int n: ingredientData) {
                deck.push(n);
            }
        }

    }
}
