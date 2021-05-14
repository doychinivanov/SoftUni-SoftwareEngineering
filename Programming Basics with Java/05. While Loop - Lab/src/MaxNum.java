import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int max = Integer.MIN_VALUE;
        String input = scan.nextLine();

        while(input.equals("Stop") == false){
            int num = Integer.parseInt(input);

            if(num > max){
                max = num;
            }

            input = scan.nextLine();
        }

        System.out.println(max);
    }
}
