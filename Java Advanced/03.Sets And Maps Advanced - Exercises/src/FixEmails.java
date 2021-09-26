import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("stop")){
            String name = input;
            String email = scan.nextLine();

            if(!(email.endsWith("us") || email.endsWith("uk") || email.endsWith("com"))){
                emails.put(name, email);
            }

            input = scan.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s" + System.lineSeparator(), key, value));
    }
}
