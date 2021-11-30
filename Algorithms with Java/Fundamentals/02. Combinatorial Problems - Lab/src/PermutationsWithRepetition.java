import java.util.Scanner;

public class PermutationsWithRepetition {
    public static String[] arrToPermute;
    public static String[] currentPermutation;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        arrToPermute = scan.nextLine().split("\\s+");
        currentPermutation = new String[arrToPermute.length];

        permute(0);
    }

    private static void permute(int index) {
        if(index == arrToPermute.length) {
            printPermutation();
            return;
        }

        for (int i = 0; i < currentPermutation.length; i++) {
            currentPermutation[i] = arrToPermute[index];
            permute(index + 1);
        }

    }

    private static void printPermutation() {
        System.out.println(String.join(" ", currentPermutation));
    }
}
