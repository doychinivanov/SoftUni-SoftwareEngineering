import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        double bonus = 0.0;
        int score = Integer.parseInt(scan.nextLine());

        if(score <= 100){
            bonus = 5;
        } else if ( score > 1000){
            bonus = score * 0.1;
        } else {
            bonus = score * 0.2;
        }

        if(score % 2 == 0){
            bonus += 1;
        }

        if(score % 10 == 5){
            bonus += 2;
        }

        System.out.println(bonus);
        System.out.println(score + bonus);
    }
}
