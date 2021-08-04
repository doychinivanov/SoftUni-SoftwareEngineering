import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        long treshHold = calculateCoolness(input);
        List<String> allValidEmojies = new ArrayList<>();
        List<String> coolEmojies = new ArrayList<>();

        String pattern = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(input);

        while(match.find()){
            allValidEmojies.add(match.group());

            long currentEmojiCoolness = 0;
            String emoji = match.group("emoji");

            for (int i = 0; i < emoji.length(); i++) {
                currentEmojiCoolness += emoji.charAt(i);
            }

            if(currentEmojiCoolness >= treshHold){
                coolEmojies.add(match.group());
            }
        }

        System.out.printf("Cool threshold: %d\n", treshHold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", allValidEmojies.size());
        System.out.println(String.join("\n", coolEmojies));
    }

    public static long calculateCoolness(String input){
        long treshHold = 1;

        String pattern = "[\\d]";
        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(input);

        while (match.find()){
            treshHold *= Integer.parseInt(match.group());
        }

        return treshHold;
    }
}
