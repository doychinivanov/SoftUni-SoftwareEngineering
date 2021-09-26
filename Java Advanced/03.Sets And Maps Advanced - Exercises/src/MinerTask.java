import java.util.LinkedHashMap;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = scan.nextLine();

        while(!input.equals("stop")){
            String resource = input;
            int quantity = Integer.parseInt(scan.nextLine());

            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);

            input = scan.nextLine();
        }

        resources.forEach((key, value) -> System.out.printf("%s -> %d" + System.lineSeparator(), key, value));
    }
}
