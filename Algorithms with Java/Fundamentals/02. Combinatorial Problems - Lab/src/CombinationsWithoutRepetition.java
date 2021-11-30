import java.util.Scanner;

public class CombinationsWithoutRepetition {
    private static String[] arr;
    private static String[] slots;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        arr = scan.nextLine().split("\\s+");

        int slotsCount = Integer.parseInt(scan.nextLine());

        slots = new String[slotsCount];

        createCombinations(0, 0);
    }

    private static void createCombinations(int mainIndex, int startIndex) {
        if(mainIndex == slots.length) {
            print(slots);
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            slots[mainIndex] = arr[i];

            createCombinations(mainIndex + 1, i + 1);
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }

}
