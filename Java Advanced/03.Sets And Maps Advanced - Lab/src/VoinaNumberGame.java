import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerDeck = readDeck(scan.nextLine());
        LinkedHashSet<Integer> secondPlayerDeck = readDeck(scan.nextLine());

        int rounds = 0;

        while(rounds < 50) {
            int firstPlayerCard = getFirstFromSet(firstPlayerDeck);
            int secondPlayerCard = getFirstFromSet(secondPlayerDeck);

            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);

            if(firstPlayerCard > secondPlayerCard){
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if(secondPlayerCard > firstPlayerCard){
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }

            if(firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()){
                break;
            }

            rounds++;
        }

        if(firstPlayerDeck.size() > secondPlayerDeck.size()){
            System.out.println("First player win!");
        } else if(firstPlayerDeck.size() < secondPlayerDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

    public static int getFirstFromSet(LinkedHashSet<Integer> currentSet){
        Iterator<Integer> iterator = currentSet.iterator();

        return iterator.next();
    }


    private static LinkedHashSet<Integer> readDeck(String line){
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
