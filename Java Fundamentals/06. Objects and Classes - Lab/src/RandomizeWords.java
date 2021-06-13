import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomizer = new Random();

        String[] words = scan.nextLine().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            int randomIndex = randomizer.nextInt(words.length);
            String temp = words[i];
            words[i] = words[randomIndex];
            words[randomIndex] = temp;
        }

        for (String word: words) {
            System.out.println(word);
        }
    }
}
