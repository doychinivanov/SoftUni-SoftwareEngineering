package CountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListCounter<Double> list = new ListCounter<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(scan.nextLine()));
        }

        System.out.println(list.compare(Double.parseDouble(scan.nextLine())));
    }
}
