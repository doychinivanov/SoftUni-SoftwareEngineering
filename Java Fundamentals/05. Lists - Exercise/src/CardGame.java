import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firsHand = Arrays
                .stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondHand = Arrays
                .stream(scan.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while(firsHand.isEmpty() == false || secondHand.isEmpty() == false){
            if(firsHand.isEmpty() || secondHand.isEmpty()){
                break;
            }

            int smallerLength = Math.min(firsHand.size(), secondHand.size());

            for (int i = 0; i < smallerLength; i++) {
                if(firsHand.get(i) == secondHand.get(i)){
                    firsHand.remove(i);
                    secondHand.remove(i);
                    break;
                } else if(firsHand.get(i) > secondHand.get(i)){
                     int winnerCard = firsHand.get(i);
                     int loserCard = secondHand.get(i);

                     firsHand.remove(i);
                     secondHand.remove(i);

                     firsHand.add(winnerCard);
                     firsHand.add(loserCard);
                     break;
                } else {
                    int winnerCard = secondHand.get(i);
                    int loserCard = firsHand.get(i);

                    firsHand.remove(i);
                    secondHand.remove(i);

                    secondHand.add(winnerCard);
                    secondHand.add(loserCard);
                    break;
                }
            }
        }

        int winnerPoints = Math.max(firsHand.stream().reduce(0, (acc, curr)-> acc + curr), secondHand.stream().reduce(0, (acc, curr)-> acc + curr));

        if(secondHand.isEmpty() == false){
            System.out.printf("Second player wins! Sum: %d", winnerPoints);
        } else if(firsHand.isEmpty() == false) {
            System.out.printf("First player wins! Sum: %d", winnerPoints);
        }
    }
}
