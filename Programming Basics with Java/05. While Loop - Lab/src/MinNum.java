import java.util.Scanner;

public class MinNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int min = Integer.MAX_VALUE;
        String input = scan.nextLine();

        while(!input.equals("Stop")){
            int num = Integer.parseInt(input);

            if(num < min){
                min = num;
            }

            input = scan.nextLine();
        }

        System.out.println(min);
    }
}