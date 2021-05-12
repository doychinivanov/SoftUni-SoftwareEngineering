import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());

        if(num != 0 && (num < 100 || num > 200)){
            System.out.println("invalid");
        }
    }
}
