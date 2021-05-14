import java.util.Scanner;

public class Graduation2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int grade = 0;
        double scores = 0;
        String name = scan.nextLine();
        boolean isFailure = false;

        while (grade < 12){
            double current = Double.parseDouble(scan.nextLine());
            grade++;

            if(current < 4){
                isFailure = true;
                break;
            }

            scores += current;
        }

        if(isFailure){
            System.out.printf("%s has been excluded at %d grade", name, grade);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", name, scores / grade);
        }
    }
}