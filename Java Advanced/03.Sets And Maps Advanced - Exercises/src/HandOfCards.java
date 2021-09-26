import java.util.*;

public class HandOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while(!input.equals("JOKER")){
            String[] playerData = input.split(": ");
            String playerName = playerData[0];
            String[] playerCards = playerData[1].split(", ");

            players.putIfAbsent(playerName, new HashSet<>());

            HashSet<String> currentPlayerHand = players.get(playerName);
            currentPlayerHand.addAll(Arrays.asList(playerCards));

            players.put(playerName, currentPlayerHand);

            input = scan.nextLine();
        }

        players.forEach((key, value) -> {
            System.out.printf("%s: %d" + System.lineSeparator(), key, calculatePoints(value));
        });
    }

    public static int calculatePoints(HashSet<String> hand){
        HashMap<Character, Integer> scale = createScale();
        int sum = 0;

        for (String card: hand) {
            char type;
            char paint;
            if(card.startsWith("10")){
                type = 'X';
                paint = card.charAt(card.length() - 1);

            } else {
                type = card.charAt(0);
                paint = card.charAt(1);

            }
            sum += scale.get(type) * scale.get(paint);
        }


        return sum;
    }

    public static HashMap<Character, Integer> createScale(){
        HashMap<Character, Integer> scale = new HashMap<>();

        scale.put('1', 1);
        scale.put('2', 2);
        scale.put('3', 3);
        scale.put('4', 4);
        scale.put('5', 5);
        scale.put('6', 6);
        scale.put('7', 7);
        scale.put('8', 8);
        scale.put('9', 9);
        scale.put('X', 10);
        scale.put('J', 11);
        scale.put('Q', 12);
        scale.put('K', 13);
        scale.put('A', 14);
        scale.put('S', 4);
        scale.put('H', 3);
        scale.put('D', 2);
        scale.put('C', 1);


        return  scale;
    }
}
