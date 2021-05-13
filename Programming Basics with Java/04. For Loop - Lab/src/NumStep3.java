import java.util.Scanner;

public class NumStep3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= x; i+=3){
            System.out.println(i);
        }
    }
}
