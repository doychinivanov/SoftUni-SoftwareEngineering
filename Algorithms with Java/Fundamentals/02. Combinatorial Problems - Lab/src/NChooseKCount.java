import java.util.Scanner;

public class NChooseKCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int n = Integer.parseInt(scan.nextLine());

        int k = Integer.parseInt(scan.nextLine());

        System.out.println(binom(n, k));

    }

    private static int binom(int n, int k) {
        if (k > n) return 0;

        if (k == 0 || k == n) return 1;

        return binom(n - 1, k -1) + binom(n - 1, k);
    }
}
