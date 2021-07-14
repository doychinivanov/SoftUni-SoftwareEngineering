import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String names = scan.nextLine();

        String regex = "\\b(?<firstName>[A-Z][a-z]+) (?<lastName>[A-Z][a-z]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(names);

        while(match.find()){
            System.out.printf("%s %s ", match.group("firstName"), match.group("lastName"));
        }
    }
}
