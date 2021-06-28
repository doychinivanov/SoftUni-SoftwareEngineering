import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (input.equals("stop") == false){
            String currentResource = input;
            int currentQuantity = Integer.parseInt(scan.nextLine());

            resources.putIfAbsent(currentResource, 0);
            resources.put(currentResource, resources.get(currentResource) + currentQuantity);

            input = scan.nextLine();
       }

        resources.forEach((k,v) -> System.out.printf("%s -> %s\n", k, v));
    }
}
