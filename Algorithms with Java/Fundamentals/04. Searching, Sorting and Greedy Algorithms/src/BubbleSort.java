import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] someArray = Arrays.stream(reader
                .readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        bubbleSort(someArray);

        printArr(someArray);
    }

    private static void bubbleSort(int[] someArray) {
        for (int currentIndex = 0; currentIndex < someArray.length; currentIndex++) {

            for (int nextIndex = currentIndex + 1; nextIndex < someArray.length; nextIndex++) {
                if (someArray[currentIndex] > someArray[nextIndex]) {
                    swap(someArray, currentIndex, nextIndex);
                }
            }
        }
    }

    private static void printArr(int[] someArray) {
        String[] tempArr = Arrays.stream(someArray).mapToObj(String::valueOf).toArray(String[]::new);

        System.out.println(String.join(" ", tempArr));
    }

    private static void swap(int[] someArray, int firstIndex, int secondIndex) {
        int temp = someArray[firstIndex];
        someArray[firstIndex] = someArray[secondIndex];
        someArray[secondIndex] = temp;
    }
}
