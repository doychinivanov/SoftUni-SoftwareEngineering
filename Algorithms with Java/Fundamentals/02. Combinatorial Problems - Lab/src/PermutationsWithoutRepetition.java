import java.util.Scanner;

public class PermutationsWithoutRepetition {
    public static String[] arrToPermute;
    public static String[] currentPermutation;
    public static boolean[] isUsed;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        arrToPermute = scan.nextLine().split("\\s+");
        currentPermutation = new String[arrToPermute.length];
        isUsed = new boolean[arrToPermute.length];

        startPermutation( 0);

    }

    private static void startPermutation(int index) {
        if(index == arrToPermute.length){
            printPermutation();
            return;
        }

        for (int i = 0; i < currentPermutation.length; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                currentPermutation[i] = arrToPermute[index];
                startPermutation(index + 1);
                isUsed[i] = false;
            }
        }
    }

    private static void printPermutation() {
        System.out.println(String.join(" ", currentPermutation));
    }
}
