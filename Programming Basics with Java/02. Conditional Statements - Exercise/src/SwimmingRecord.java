import java.util.Scanner;

public class SwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double secPerM = Double.parseDouble(scan.nextLine());

        double time = distance * secPerM;
        double delay = Math.floor(distance / 15) * 12.5;
        time += delay;

        if(time < record){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(record - time));
        }

    }
}
