import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int handledByFirstEmployee = Integer.parseInt(scan.nextLine());
        int handledBySecondEmployee = Integer.parseInt(scan.nextLine());
        int handledByThirdEmployee = Integer.parseInt(scan.nextLine());
        int totalAmountOfPeople = Integer.parseInt(scan.nextLine());

        int totalHandledPerHour = handledByFirstEmployee + handledBySecondEmployee + handledByThirdEmployee;
        int hoursNeeded = 0;

        if(totalAmountOfPeople > 0){
            while (totalAmountOfPeople > 0){
                if(hoursNeeded == 0 || hoursNeeded % 4 != 0){
                    totalAmountOfPeople -= totalHandledPerHour;
                }
                hoursNeeded++;
            }

            if(hoursNeeded % 4 == 0){
                hoursNeeded++;
            }
        }

        System.out.printf("Time needed: %dh.", hoursNeeded);
    }
}