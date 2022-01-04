import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficient {
    private static long memory[][];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        memory = new long[n + 1][k + 1];
        long binomial = caclBinom(n, k);

        System.out.println(binomial);
    }

    private static long caclBinom(int n, int k) {
        if (k == 0 || k == n) return 1;

        if (memory[n][k] != 0) return memory[n][k];

        return memory[n][k] = caclBinom(n -1, k) + caclBinom(n - 1, k -1);
    }
}
