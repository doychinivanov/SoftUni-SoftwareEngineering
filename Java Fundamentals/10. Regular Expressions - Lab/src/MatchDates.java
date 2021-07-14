import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<String> result = new ArrayList<>();
        String years = scan.nextLine();
        String pattern = "\\b(?<day>[\\d]{2})([\\.|\\/|-])(?<month>[A-Z][a-z]{2})\\2(?<year>[1-9][0-9]{3})\\b";

        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(years);

        while (match.find()){
            String formatDate = String.format("Day: %s, Month: %s, Year: %s", match.group("day"), match.group("month"), match.group("year"));
            result.add(formatDate);
        }

        System.out.println(String.join("\n", result));
    }
}
