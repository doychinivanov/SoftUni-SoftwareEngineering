import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double totalTickets = 0;
        int totalStandard = 0;
        int totalStudent = 0;
        int totalKid = 0;

        String input = scan.nextLine();

        while (input.equals("Finish") == false){
            String movie = input;
            double places = Double.parseDouble(scan.nextLine());
            int currentSold = 0;
            String type = scan.nextLine();

            while (type.equals("End") == false && type.equals("Finish") == false){
                totalTickets++;
                currentSold++;

                if(type.equals("kid")){
                    totalKid++;
                } else if(type.equals("student")){
                    totalStudent++;
                } else if(type.equals("standard")){
                    totalStandard++;
                }

                if(currentSold >= places){
                    break;
                }

                type = scan.nextLine();
            }

            System.out.printf("%s - %.2f%% full.%n", movie, (currentSold * 100) / places);

            if(type.equals("Finish")){
                input = type;
            } else {
                input = scan.nextLine();
            }
        }

        System.out.printf("Total tickets: %.0f%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", (totalStudent * 100) / totalTickets);
        System.out.printf("%.2f%% standard tickets.%n", (totalStandard * 100) / totalTickets);
        System.out.printf("%.2f%% kids tickets.", (totalKid * 100) / totalTickets);

    }
}