import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String emailRegex = "(?<=\\s)([a-z]+|\\d+)(\\d+|\\w+|\\.+|-+)([a-z]+|\\d+)\\@[a-z]+\\-?[a-z]+\\.[a-z]+(\\.[a-z]+)?";
        Pattern emailPattern = Pattern.compile(emailRegex);
        String input = scan.nextLine();

            Matcher match = emailPattern.matcher(input);

            while(match.find()){
                System.out.println(match.group());
            }



    }
}
