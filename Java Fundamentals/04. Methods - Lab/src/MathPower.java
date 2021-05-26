import java.math.BigDecimal;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigDecimal x = new BigDecimal(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());

        System.out.println(riseToPower(x, y));
    }

    private static BigDecimal riseToPower(BigDecimal x, int y){
        return x.pow(y);
    }
}
