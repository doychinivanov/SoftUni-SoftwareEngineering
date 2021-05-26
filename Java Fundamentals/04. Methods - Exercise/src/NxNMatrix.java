import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        System.out.println(printRow(number, printLine(number)));
    }

    private static String printLine(int n){
        String result = "";

        for (int i = 0; i < n; i++) {
            result += n + " ";
        }

        return result;
    }

    private static String printRow(int n, String line){
        String result = "";

        for (int i = 0; i < n; i++) {
            result += line + "\n";
        }

        return result;
    }
}
