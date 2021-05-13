import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());
        double income = rows * columns;

        if(type.equals("Premiere")){
            income *= 12;
        } else if(type.equals("Normal")){
            income *= 7.5;
        } else if(type.equals("Discount")){
            income *= 5;
        }

        System.out.printf("%.2f leva", income);
    }
}
