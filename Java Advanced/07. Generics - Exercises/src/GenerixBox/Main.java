package GenerixBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<String>();

        for (int i = 0; i < n; i++) {
            box.addElements(scan.nextLine());
        }

        System.out.println(box.toString());
    }
}
