import java.util.Scanner;

public class MiddleChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        System.out.println(findMiddle(input));

    }

    public static String findMiddle(String input){
        String result = "";
        int middle = (int)Math.ceil(input.length() / 2);

        if(input.length() % 2 == 0){
            result += input.charAt(middle-1) + "" + input.charAt(middle);
        } else {
            result += input.charAt(middle);
        }

        return result;
    }
}
