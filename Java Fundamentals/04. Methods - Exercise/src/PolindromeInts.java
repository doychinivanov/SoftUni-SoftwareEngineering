import java.util.Scanner;

public class PolindromeInts {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String input = scan.nextLine();

        while(input.equals("END") == false){
            int n = Integer.parseInt(input);

            System.out.println(checkPalindrome(n));

            input = scan.nextLine();
        }
    }

    public static String checkPalindrome(int n){
        String output = "";

        if(Integer.toString(n).equals(new StringBuilder(Integer.toString(n)).reverse().toString())){
            output = "true";
        } else {
            output = "false";
        }

        return  output;
    }
}
