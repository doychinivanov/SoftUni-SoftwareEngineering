import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    private static long[] memoDP;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        memoDP = new long[n +1];

        long fib = calcFib(n);

        System.out.println(fib);
    }

    private static long calcFib(int n) {
        if (n <= 2) return 1;

        if (memoDP[n] != 0) return memoDP[n];

        return memoDP[n] = calcFib(n - 1) + calcFib(n - 2);
    }

}
