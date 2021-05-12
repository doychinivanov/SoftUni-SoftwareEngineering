import java.util.Scanner;

public class Time15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int totalTime = hour * 60 + minutes + 15;

        hour = totalTime / 60;
        minutes = totalTime % 60;

        if(hour >= 24){
            hour -= 24;
        }

        System.out.printf("%d:%02d", hour, minutes);
    }
}
