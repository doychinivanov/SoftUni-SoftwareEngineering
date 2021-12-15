import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader
                .readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr);

        printArr(arr);
    }

    private static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length -1);
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if(begin >= end) return;

        int middle = (begin + end) / 2;

        mergeSort(arr, begin, middle);
        mergeSort(arr, middle + 1, end);

        merge(arr, begin, middle, end);
    }

    private static void merge(int[] arr, int begin, int middle, int end) {
        if(middle < 0 || middle >= arr.length || arr[middle] < arr[middle + 1]) return;

        int leftIndex = begin;
        int rightIndex = middle + 1;

        int[] helper = new int[arr.length];

        for (int i = begin; i <= end ; i++) {
            helper[i] = arr[i];
        }

        for (int i = begin; i <= end; i++) {
            if (leftIndex > middle) {
                arr[i] = helper[rightIndex++];
            } else if (rightIndex > end) {
                arr[i] = helper[leftIndex++];
            } else if (helper[leftIndex] < helper[rightIndex]) {
                arr[i] = helper[leftIndex++];
            } else {
                arr[i] = helper[rightIndex++];
            }
        }
    }

    private static void printArr(int[] someArray) {
        String[] tempArr = Arrays.stream(someArray).mapToObj(String::valueOf).toArray(String[]::new);

        System.out.println(String.join(" ", tempArr));
    }
}
