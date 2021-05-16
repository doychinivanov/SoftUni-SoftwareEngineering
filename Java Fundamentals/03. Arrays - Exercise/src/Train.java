import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        String[] train = new String[n];

        for (int i = 0; i < n; i++) {
            int amount = Integer.parseInt(scan.nextLine());
            sum+= amount;
            train[i] = Integer.toString(amount);
        }

        System.out.println(String.join(" ", train));
        System.out.println(sum);

    }
}