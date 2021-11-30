import java.util.Scanner;

public class PermutationWithSwap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arrToPermute = scan.nextLine().split("\\s+");

        permute(arrToPermute,0);
    }

    private static void permute(String[] arrToPermute, int index) {
        if(index == arrToPermute.length) {
            printArr(arrToPermute);
            return;
        }

        permute(arrToPermute, index + 1);

        for (int i = index + 1; i < arrToPermute.length; i++) {
            swap(arrToPermute, index, i);
            permute(arrToPermute, index + 1);
            swap(arrToPermute, index, i);
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