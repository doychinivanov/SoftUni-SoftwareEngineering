import java.util.Scanner;

public class SmallestOf3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());
        int z = Integer.parseInt(scan.nextLine());

        System.out.println(findTheSmallest(x, y ,z));

    }

    public static int findTheSmallest(int x, int y, int z){
        return Math.min(x, Math.min(y,z));
    }
}
