import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] forbiddenWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String word: forbiddenWords) {
            text = text.replace(word, "*".repeat(word.length()));
        }

        System.out.println(text);

    }
}
