import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberToFindFactorialOf = Integer.parseInt(scan.nextLine());

        long factorial = findFactorialTopToBot(numberToFindFactorialOf);

        System.out.println(factorial);
    }

    public static long findFactorialTopToBot(int n) {
        if(n == 1) {
            return 1;
        }

        return n * findFactorialTopToBot(n - 1);
    }

//    public static long findFactorialBotToTop(int n, int start) {
//        if (start == n) {
//            return n;
//        }
//
//        return start * findFactorialBotToTop(n, start + 1);
//    }
}
