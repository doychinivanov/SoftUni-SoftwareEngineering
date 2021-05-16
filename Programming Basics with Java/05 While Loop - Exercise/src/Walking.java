import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        boolean headedHome = false;
        int totalSteps = 0;

        while(totalSteps < 10000 && !headedHome){
            String input = scan.nextLine();
            int currentSteps = 0;

            if(input.equals("Going home")){
                headedHome = true;
                currentSteps = Integer.parseInt(scan.nextLine());
            } else {
                currentSteps = Integer.parseInt(input);
            }

            totalSteps += currentSteps;
        }

        if(totalSteps < 10000){
            System.out.printf("%d more steps to reach goal.", 10000 - totalSteps);
        } else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", totalSteps - 10000);
        }

    }
}