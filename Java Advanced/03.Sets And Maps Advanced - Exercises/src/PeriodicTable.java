import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] chemicals = scan.nextLine().split("\\s+");

            elements.addAll(Arrays.asList(chemicals));
        }

        System.out.println(String.join(" ", elements));
    }
}
