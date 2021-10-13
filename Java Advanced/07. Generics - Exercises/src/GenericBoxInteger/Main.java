package GenericBoxInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<Integer> box = new Box<Integer>();

        for (int i = 0; i < n; i++) {
            box.addElements(Integer.parseInt(scan.nextLine()));
        }

        System.out.println(box);
    }
}
