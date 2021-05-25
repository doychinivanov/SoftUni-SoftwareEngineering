import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double height = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());

        double area = calcArea(height, width);
        System.out.printf("%.0f", area);
    }

    private static double calcArea(double x, double y){
        return x * y;
    }
}
