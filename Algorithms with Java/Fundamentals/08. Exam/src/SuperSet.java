import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuperSet {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numbers = Arrays
                .stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println();
        for (int i = 0; i < numbers.length; i++) {

            int[] slots = new int[i + 1];

            findSubSet(0, 0, slots);
        }
    }

    private static void findSubSet(int mainIndex, int startIndex, int[] slots) {
        if (mainIndex == slots.length) {
            printSet(slots);
            return;
        }


        for (int i = startIndex; i < numbers.length; i++) {
            slots[mainIndex] = numbers[i];

            findSubSet(mainIndex + 1, i + 1, slots);
        }
    }

    private static void printSet(int[] curSub) {
        StringBuilder result = new StringBuilder();

        for (int j : curSub) {
            result.append(j).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
