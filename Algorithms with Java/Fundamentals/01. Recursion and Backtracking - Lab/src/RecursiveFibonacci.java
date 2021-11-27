import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memo;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int wantedFibonacciOrdinal = Integer.parseInt(scan.nextLine());

        memo = new long[wantedFibonacciOrdinal + 1];
        System.out.println(recursiveFibonacciWithMemoization(wantedFibonacciOrdinal));
    }

    private static long recursiveFibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = recursiveFibonacciWithMemoization(n - 1) + recursiveFibonacciWithMemoization(n - 2);
        return memo[n];
    }
}
