package CountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListCounter<String> list = new ListCounter<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            list.add(scan.nextLine());
        }

        System.out.println(list.compare(scan.nextLine()));
    }
}
