import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arrToPermute = scan.nextLine().split("\\s+");

        permute(arrToPermute, 0);
    }

    private static void permute(String[] arrToPermute, int mainArrIndex) {
        if(mainArrIndex == arrToPermute.length) {
            printArr(arrToPermute);
            return;
        }

        permute(arrToPermute, mainArrIndex + 1);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(arrToPermute[mainArrIndex]);

        for (int currentPermutationIndex = mainArrIndex + 1; currentPermutationIndex < arrToPermute.length; currentPermutationIndex++) {
            if(!swapped.contains(arrToPermute[currentPermutationIndex])){
                swap(arrToPermute, mainArrIndex, currentPermutationIndex);
                permute(arrToPermute, mainArrIndex + 1);
                swap(arrToPermute, mainArrIndex, currentPermutationIndex);
                swapped.add(arrToPermute[currentPermutationIndex]);
            }
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void printArr(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
