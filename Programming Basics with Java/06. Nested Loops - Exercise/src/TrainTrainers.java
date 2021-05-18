import java.util.Scanner;

public class TrainTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int jury = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        double totalScore = 0;
        int totalGrades = 0;

        while (input.equals("Finish") == false){
            String task = input;
            double currentTaskTotal = 0;

            for (int i = 0; i < jury; i++) {
                double grade = Double.parseDouble(scan.nextLine());
                currentTaskTotal += grade;
                totalScore += grade;
                totalGrades++;
            }

            System.out.printf("%s - %.2f.%n", task, currentTaskTotal / jury);
            input = scan.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.", totalScore / totalGrades);

    }
}