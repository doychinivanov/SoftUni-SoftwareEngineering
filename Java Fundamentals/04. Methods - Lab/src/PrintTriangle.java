import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            printTrian(1, i);
        }

        for (int i = n; i >= 1 ; i--) {
            printTrian(1, i);
        }

    }

    public static void printTrian(int start, int end){
        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
