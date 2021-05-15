import java.util.Scanner;

public class ExamPrep {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxFails = Integer.parseInt(scan.nextLine());
        String lastTask = "";
        double scores = 0;
        int amount = 0;
        int fails = 0;
        boolean hasFailed = true;

        while (maxFails > fails){
            String task = scan.nextLine();
            if(task.equals("Enough")){
                hasFailed = false;
                break;
            }

            int currentGrade = Integer.parseInt(scan.nextLine());
            if(currentGrade <= 4){
                fails++;
            }

            scores += currentGrade;
            amount++;
            lastTask = task;
        }

        if(hasFailed){
            System.out.printf("You need a break, %d poor grades.", fails);
        } else {
            System.out.printf("Average score: %.2f%n", scores / amount);
            System.out.printf("Number of problems: %d%n", amount);
            System.out.printf("Last problem: %s", lastTask);
        }
    }
}