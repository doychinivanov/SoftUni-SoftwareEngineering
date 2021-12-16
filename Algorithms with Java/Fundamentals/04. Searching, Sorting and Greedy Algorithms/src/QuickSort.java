import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader
                .readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(arr, 0, arr.length - 1);

        printArr(arr);
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;

        int partitionIndex = partition(a, start, end);
        quickSort(a, start, partitionIndex - 1);
        quickSort(a, partitionIndex + 1, end);
    }

    private static int partition (int[] arr, int start, int end) {
        int pivotElement = findPivot(arr, start, end);
        int i = (start - 1);

        for (int currentIndex = start; currentIndex < end; currentIndex++) {
            if (arr[currentIndex] < pivotElement) {
                i++;

                if(arr[i] != arr[currentIndex]) swap(arr, i, currentIndex);
            }
        }

        i++;
        if (arr[i] != arr[end]) swap(arr, i, end);

        return i ;
    }

    private static int findPivot(int[] arr, int start, int end) {
        int arrMiddleIndex = (start + end) / 2;

        int averageSizedElement = Math.max(Math.min(arr[start], arr[arrMiddleIndex]), arr[end]);

        int initialPosition = averageSizedElement == arr[start]
                ? start
                : averageSizedElement == arr[arrMiddleIndex]
                    ? arrMiddleIndex
                    : end;

        if (initialPosition != end) {
            swap(arr, initialPosition, end);
        }

        return averageSizedElement;
    }

    private static void swap(int[] someArray, int firstIndex, int secondIndex) {
        int temp = someArray[firstIndex];
        someArray[firstIndex] = someArray[secondIndex];
        someArray[secondIndex] = temp;
    }

    private static void printArr(int[] someArray) {
        String[] tempArr = Arrays.stream(someArray).mapToObj(String::valueOf).toArray(String[]::new);

        System.out.println(String.join(" ", tempArr));
    }
}
