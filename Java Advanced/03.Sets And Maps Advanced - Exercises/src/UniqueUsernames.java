import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            usernames.add(scan.nextLine());
        }

        usernames.forEach(System.out::println);
    }
}
