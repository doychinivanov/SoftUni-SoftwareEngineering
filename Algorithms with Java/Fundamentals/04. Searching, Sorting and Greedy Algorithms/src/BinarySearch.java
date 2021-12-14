import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] someArray = Arrays.stream(reader
                .readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetNumber = Integer.parseInt(reader.readLine());

        int elementIndexInArray = findIndexOfElementInArray(someArray, targetNumber);

        System.out.println(elementIndexInArray);
    }

    private static int findIndexOfElementInArray(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            int arrMiddle = (startIndex + endIndex) / 2;

            int currentElement = arr[arrMiddle];

            if (currentElement > target) {
                endIndex = arrMiddle - 1;
            } else if (currentElement < target) {
                startIndex = arrMiddle + 1;
            } else {
                return arrMiddle;
            }

        }

        return -1;
    }
}
