package CardinalRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        CardValue[] values = CardValue.values();

        System.out.println(scan.nextLine() + ":");


        for (CardValue value: values) {
            System.out.println(value);
        }
    }
}
