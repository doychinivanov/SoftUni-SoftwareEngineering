import java.util.Scanner;

public class NumberN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());

        for (int i = x; i >=1; i--){
            System.out.println(i);
        }
    }
}
