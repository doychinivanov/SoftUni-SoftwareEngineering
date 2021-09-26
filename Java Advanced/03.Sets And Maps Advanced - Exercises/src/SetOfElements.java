import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();


        int[] lengths = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetLength = lengths[0];
        int secondSetLength = lengths[1];

        fillSet(firstSet, firstSetLength, scan);
        fillSet(secondSet, secondSetLength, scan);

        firstSet.retainAll(secondSet);

        firstSet.forEach(x -> System.out.print(x + " "));
    }

    private static void fillSet(LinkedHashSet<Integer> set, int setLength, Scanner scan){
        for (int i = 0; i < setLength; i++) {
            set.add(Integer.parseInt(scan.nextLine()));
        }
    }
}
