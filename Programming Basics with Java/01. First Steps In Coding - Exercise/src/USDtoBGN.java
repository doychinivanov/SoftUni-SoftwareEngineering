import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double BGN = Double.parseDouble(scan.nextLine()) * 1.79549;

        System.out.println(BGN);
    }
}
