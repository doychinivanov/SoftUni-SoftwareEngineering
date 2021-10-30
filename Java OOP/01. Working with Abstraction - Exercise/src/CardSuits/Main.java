package CardSuits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        scan.nextLine();

        Suits[] suits = Suits.values();

        System.out.println("Card Suits:");
        for (Suits suit: suits) {
            System.out.println(suit);;
        }
    }
}
