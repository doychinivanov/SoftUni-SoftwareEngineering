import java.util.Scanner;

public class DivideNoRemain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 0; i < n; i++) {
            int currentNum  = Integer.parseInt(scan.nextLine());

            if(currentNum % 2==0 && currentNum % 3==0 && currentNum % 4==0){
                p1++;
                p2++;
                p3++;
            } else if(currentNum % 2==0 && currentNum % 4==0){
                p1++;
                p3++;
            } else if(currentNum%2==0 && currentNum%3==0){
                p1++;
                p2++;
            } else if(currentNum%2==0){
                p1++;
            } else if(currentNum%3==0){
                p2++;
            } else if(currentNum%4==0){
                p3++;
            }
        }

        System.out.printf("%.2f%%%n", p1 / n * 100);
        System.out.printf("%.2f%%%n", p2 / n * 100);
        System.out.printf("%.2f%%%n", p3 / n * 100);
    }
}