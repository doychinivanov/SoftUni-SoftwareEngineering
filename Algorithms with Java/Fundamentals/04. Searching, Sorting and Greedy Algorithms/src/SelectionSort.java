import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] someArray = Arrays.stream(reader
                .readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        selectionSort(someArray);
        
        printArr(someArray);
    }

    private static void printArr(int[] someArray) {
        String[] tempArr = Arrays.stream(someArray).mapToObj(String::valueOf).toArray(String[]::new);

        System.out.println(String.join(" ", tempArr));
    }

    private static void selectionSort(int[] someArray) {
        for (int currentIndex = 0; currentIndex < someArray.length; currentIndex++) {
            int indexOfSmallestElementLeft = currentIndex;

            for (int j = currentIndex + 1; j < someArray.length; j++) {
                if (someArray[j] < someArray[indexOfSmallestElementLeft]) indexOfSmallestElementLeft = j;
            }

            swap(someArray, currentIndex, indexOfSmallestElementLeft);
        }
    }

    private static void swap(int[] someArray, int firstIndex, int secondIndex) {
        int temp = someArray[firstIndex];
        someArray[firstIndex] = someArray[secondIndex];
        someArray[secondIndex] = temp;
    }
}
