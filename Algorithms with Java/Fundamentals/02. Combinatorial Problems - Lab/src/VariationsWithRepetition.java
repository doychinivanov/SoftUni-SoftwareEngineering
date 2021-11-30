import java.util.Scanner;

public class VariationsWithRepetition {
    private static String[] arr;
    private static String[] slots;
    private static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        arr = scan.nextLine().split("\\s+");

        int slotsCount = Integer.parseInt(scan.nextLine());

        slots = new String[slotsCount];
        isUsed = new boolean[arr.length];

        createVariations(0);
    }

    private static void createVariations(int mainIndex) {
        if(mainIndex == slots.length){
            print(slots);
            return;
        }

        for (String s : arr) {
            slots[mainIndex] = s;
            createVariations(mainIndex + 1);
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
