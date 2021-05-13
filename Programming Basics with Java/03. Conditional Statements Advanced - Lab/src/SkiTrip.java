import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int days = Integer.parseInt(scan.nextLine()) - 1;
        String roomType = scan.nextLine();
        String grade = scan.nextLine();
        double price = 0;

        if(roomType.equals("room for one person")){
            price = days * 18;
        } else if(roomType.equals("apartment")){
            price = days * 25;

            if(days < 10){
                price *= 0.7;
            } else if(days>= 10 && days<= 15){
                price *= 0.65;
            } else {
                price *= 0.5;
            }
        } else if (roomType.equals("president apartment")) {
            price = days * 35;

            if(days < 10){
                price *= 0.9;
            } else if(days>= 10 && days<= 15){
                price *= 0.85;
            } else {
                price *= 0.80;
            }
        }

        if(grade.equals("positive")){
            price *= 1.25;
        } else {
            price *= 0.9;
        }

        System.out.printf("%.2f", price);
    }
}
