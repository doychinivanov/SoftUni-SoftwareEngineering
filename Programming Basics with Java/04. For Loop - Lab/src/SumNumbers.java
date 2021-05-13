import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());
        int result = 0;

        for (int i = 0; i < x; i++){
            result += Integer.parseInt(scan.nextLine());
        }

        System.out.println(result);
    }
}
