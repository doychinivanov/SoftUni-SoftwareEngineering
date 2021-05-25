import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int times = Integer.parseInt(scan.nextLine());

        System.out.println(repeat(input, times));

    }
        private static String repeat(String input, int times){
            String result = "";
            for (int i = 0; i < times ; i++) {
                result += input;
            }

            return result;
        }
}
