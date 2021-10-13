package SwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<Integer> box = new Box<Integer>();

        for (int i = 0; i < n; i++) {
            box.addElements(Integer.parseInt(scan.nextLine()));
        }

        int[] indexes = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        box.swap(indexes[0], indexes[1]);

        System.out.println(box.toString());
    }
}
