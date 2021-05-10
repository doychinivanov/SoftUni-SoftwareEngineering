import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        double occupiedSpace = Double.parseDouble(scan.nextLine());

        int tankVolume = length * width * height;
        double litres = tankVolume * 0.001 * (1 - occupiedSpace * 0.01);

        System.out.printf("%.2f", litres);
    }
}
