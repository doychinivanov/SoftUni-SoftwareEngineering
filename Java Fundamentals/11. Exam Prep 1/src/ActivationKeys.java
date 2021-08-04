import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String initialKey = scan.nextLine();

        String input = scan.nextLine();

        while(input.equals("Generate") == false){
            String[] inputData = input.split(">>>");
            String command = inputData[0];

            if(command.equals("Contains")){
                checkContains(initialKey, inputData[1]);
            } else if(command.equals("Flip")){
                String charCase = inputData[1];
                int startIndex = Integer.parseInt(inputData[2]);
                int endIndex = Integer.parseInt(inputData[3]);

                initialKey = changeCase(initialKey, startIndex, endIndex, charCase);
            } else if (command.equals("Slice")){
                int startIndex = Integer.parseInt(inputData[1]);
                int endIndex = Integer.parseInt(inputData[2]);

                initialKey = cutKey(initialKey, startIndex, endIndex);
            }

            input = scan.nextLine();
        }

        System.out.printf("Your activation key is: %s", initialKey);
    }

    public static void checkContains(String originalKey, String substring){
        if(originalKey.contains(substring)){
            System.out.printf("%s contains %s\n", originalKey, substring);
        } else {
            System.out.println("Substring not found!");
        }
    }

    public static String changeCase(String originalKey, int startIndex, int endIndex, String charCase){
        StringBuilder result = new StringBuilder();

        result.append(originalKey.substring(0, startIndex));

        if(charCase.equals("Upper")){
            result.append(originalKey.substring(startIndex, endIndex).toUpperCase(Locale.ROOT));
        } else {
            result.append(originalKey.substring(startIndex, endIndex).toLowerCase(Locale.ROOT));
        }

        result.append(originalKey.substring(endIndex));

        System.out.println(result);
        return result.toString();
    }

    public static String cutKey(String originalKey, int startIndex, int endIndex){
        StringBuilder result = new StringBuilder();

        result.append(originalKey, 0, startIndex);
        result.append(originalKey.substring(endIndex));

        System.out.println(result);
        return result.toString();
    }
}
