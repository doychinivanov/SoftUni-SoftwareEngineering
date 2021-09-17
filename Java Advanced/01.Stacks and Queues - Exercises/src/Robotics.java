import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nonParsedRobots = scan.nextLine().split(";");

        ArrayDeque<String> taskThread = new ArrayDeque<>();
        String[] robotNames = new String[nonParsedRobots.length];
        int[][] robotTimes = parseRobots(nonParsedRobots, robotNames);
        int timeInSeconds = turnTimeToSeconds(scan.nextLine());

        String input = scan.nextLine();

        while (input.equals("End") == false){
            taskThread.offer(input);

            input = scan.nextLine();
        }

        while (taskThread.isEmpty() == false){
            String currentTask = taskThread.poll();
            boolean taskIsBeingProcessed = false;
            timeInSeconds++;
            decreaseWorkingTime(robotTimes[1]);

            for (int i = 0; i < robotTimes[1].length; i++) {
                String currentRobotName = robotNames[i];
                int currentRobotTimeCapacity = robotTimes[0][i];
                int currentRobotActiveTime = robotTimes[1][i];

                boolean currentRobotIsFree = currentRobotActiveTime == 0;

                if(currentRobotIsFree){
                    System.out.printf("%s - %s %s\n", currentRobotName, currentTask, parseTime(timeInSeconds));
                    robotTimes[1][i] = currentRobotTimeCapacity;
                    taskIsBeingProcessed = true;
                    break;
                }
            }

            if(taskIsBeingProcessed == false){
                taskThread.offer(currentTask);
            }
        }
    }

    private static void decreaseWorkingTime(int[] robotsTime) {
        for (int i = 0; i < robotsTime.length; i++) {
            if(robotsTime[i] > 0){
                robotsTime[i]--;
            }
        }
    }

    private static String parseTime(int timeInSeconds){
        long hours = (timeInSeconds / 3600) % 24;
        long minutes = (timeInSeconds % 3600) / 60;
        long seconds = timeInSeconds % 60;

        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }

    private static int turnTimeToSeconds(String time){
        String[] timeData = time.split(":");
        int timeInSeconds = 0;

        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        timeInSeconds = hours * 3600 + minutes * 60 + seconds;

        return timeInSeconds;
    }

    private static int[][] parseRobots(String[] nonParsedRobots, String[] robotNames){
        int[][] robotTimes = new int[2][nonParsedRobots.length];

        for (int i = 0; i < nonParsedRobots.length; i++) {
            String currentNonParsedRobot = nonParsedRobots[i];
            String robotName = currentNonParsedRobot.split("-")[0];
            int processingTime = Integer.parseInt(currentNonParsedRobot.split("-")[1]);

            robotNames[i] = robotName;
            robotTimes[0][i] = processingTime;
            robotTimes[1][i] = 0;
        }

        return robotTimes;
    }
}
