import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Map<Character, Integer> letters = new LinkedHashMap<>();
        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' '){
                letters.putIfAbsent(input.charAt(i), 0);
                letters.put(input.charAt(i), letters.get(input.charAt(i)) + 1);
            }
        }

        letters.forEach((k,v) -> System.out.printf("%s -> %s\n", k, v));

//        for (Map.Entry<Character, Integer> entry: letters.entrySet()) {
//            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
//        }
    }
}