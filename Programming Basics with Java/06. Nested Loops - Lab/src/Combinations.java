import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int combinations = 0;
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= 25; i++) {
            for (int j = 0; j <= 25; j++) {
                for (int k = 0; k <= 25; k++) {
                    if(i + j + k == n){
                        combinations++;
                    }
                }
            }
        }

        System.out.println(combinations);
    }
}