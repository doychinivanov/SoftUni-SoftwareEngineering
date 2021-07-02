import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String input = scan.nextLine();

        while(input.equals("end") == false){
            String reversedString = new StringBuilder(input).reverse().toString();

            System.out.printf("%s = %s\n", input, reversedString);

            input = scan.nextLine();
        }
    }
}
