import java.util.Scanner;

public class ReverseArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] input = scan.nextLine().split(" ");

        for (int i = 0; i < input.length / 2; i++) {
            String temp = input[i];
            input[i] = input[input.length -1 - i];
            input[input.length -1 - i] = temp;
        }

        System.out.println(String.join(" ", input));
    }
}