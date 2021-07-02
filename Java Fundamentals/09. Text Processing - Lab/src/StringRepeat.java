import java.util.Scanner;

public class StringRepeat {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] words = scan.nextLine().split("\\s+");

        for (String word: words) {
            String repeatedWord = repeatWord(word, word.length());
            System.out.print(repeatedWord);
        }
    }

    public static String repeatWord(String word, int repetitionCount){
        StringBuilder result = new StringBuilder();

        result.append(word.repeat(repetitionCount));

        return result.toString();
    }
}
