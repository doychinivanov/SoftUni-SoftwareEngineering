import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = Double.parseDouble(scan.nextLine());
        String operator = scan.nextLine();
        double b = Double.parseDouble(scan.nextLine());
        double result = calc(a, b , operator);

        System.out.printf(new DecimalFormat("0.##").format(result));
    }

    public static double calc(double x, double y, String operator){
        double result = 0;

        switch (operator){
            case "*": result = x * y;
            break;
            case "+": result = x +y;
            break;
            case "/": result = x / y;
            break;
            case "-": result = x - y;
            break;
        }

        return result;
    }
}
