import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> binary = new ArrayDeque<>();

        int decimal = Integer.parseInt(scan.nextLine());

        if(decimal == 0){
            binary.push(Integer.toString(decimal));
        }

        while(decimal != 0){
            binary.push(Integer.toString(decimal % 2));
            decimal /= 2;
        }

        System.out.println(String.join("", binary));
    }
}
