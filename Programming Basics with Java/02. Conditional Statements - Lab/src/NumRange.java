import java.util.Scanner;

public class NumRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        if(num < 100){
            System.out.println("Less than 100");
        } else if ( num >= 100 && num <= 200){
            System.out.println("Between 100 and 200");
        } else {
            System.out.println("Greater than 200");
        }
    }
}
