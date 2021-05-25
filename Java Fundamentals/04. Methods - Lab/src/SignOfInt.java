import java.util.Scanner;

public class SignOfInt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        checkInt(Integer.parseInt(scan.nextLine()));
    }

    public static void checkInt(int n){
        if(n == 0){
            System.out.printf("The number %d is zero.", n);
        } else if(n > 0){
            System.out.printf("The number %d is positive.", n);
        } else if(n < 0){
            System.out.printf("The number %d is negative.", n);

        }
    }
}
