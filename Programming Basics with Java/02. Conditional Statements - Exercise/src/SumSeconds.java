import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int totalTime = Integer.parseInt(scan.nextLine()) + Integer.parseInt(scan.nextLine()) + Integer.parseInt(scan.nextLine());
        int minutes = totalTime/60;
        int seconds = totalTime % 60;

        if(seconds < 10) {
            System.out.printf("%d:0%d", minutes, seconds);
        } else {
            System.out.printf("%d:%d", minutes, seconds);
        }
    }
}
