import java.util.Scanner;

public class Literature {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pages = Integer.parseInt(scan.nextLine());
        int pagesPerHour = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());

        int hoursToReadBook = pages / pagesPerHour;
        int hoursPerDay = hoursToReadBook / days;

        System.out.println(hoursPerDay);
    }
}
