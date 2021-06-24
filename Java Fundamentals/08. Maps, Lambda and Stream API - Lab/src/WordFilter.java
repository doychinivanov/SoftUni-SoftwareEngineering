import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] evenLengthWords = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);

        System.out.println(String.join("\n", evenLengthWords));
    }
}