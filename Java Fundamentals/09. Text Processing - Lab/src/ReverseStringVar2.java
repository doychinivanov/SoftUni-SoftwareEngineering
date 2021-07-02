import java.util.Scanner;

public class ReverseStringVar2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (input.equals("end") == false){
            String reversedString = reverseString(input);

            System.out.printf("%s = %s\n", input, reversedString);

            input = scan.nextLine();
        }
    }

    public static String reverseString(String str) {
        if (str.isEmpty()){
            return str;
        }

        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
