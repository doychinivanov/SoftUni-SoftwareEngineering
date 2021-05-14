import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String username = scan.nextLine();
        String pass = scan.nextLine();

        String input = scan.nextLine();
        while(pass.equals(input) == false){
            input = scan.nextLine();
        }

        System.out.printf("Welcome %s!", username);
    }
}
