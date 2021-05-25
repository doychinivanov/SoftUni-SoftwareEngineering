import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        double grade = Double.parseDouble(scan.nextLine());
        gradeInWords(grade);
    }

    public static void gradeInWords(double n){
        String grade = "";

        if(n < 3){
            grade = "Fail";
        } else if (n >= 3 && n < 3.5){
            grade = "Poor";
        } else if (n >= 3.5 && n < 4.5){
            grade = "Good";
        } else if (n >= 4.5 && n < 5.5){
            grade = "Very good";
        } else if (n >= 5.5){
            grade = "Excellent";
        }

        System.out.println(grade);
    }
}
