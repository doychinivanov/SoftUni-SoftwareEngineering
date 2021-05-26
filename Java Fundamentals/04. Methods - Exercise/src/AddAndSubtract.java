import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());
        int z = Integer.parseInt(scan.next());

        System.out.println(subtract(sum(x,y), z));
    }

    public static int sum(int x, int y){
        return x + y;
    }

    public static int subtract(int x, int z){
        return x - z;
    }
}
