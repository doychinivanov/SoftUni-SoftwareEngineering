import java.util.Scanner;

public class SumNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int input = Integer.parseInt(scan.nextLine());
        int sum = 0;

        while(sum < input){
            sum += Integer.parseInt(scan.nextLine());
        }

        System.out.println(sum);
    }
}
