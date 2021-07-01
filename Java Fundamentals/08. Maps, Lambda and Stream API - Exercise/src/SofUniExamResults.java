import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SofUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> submissionsPerLanguage = new LinkedHashMap<>();
        Map<String, Integer> pointsPerContestant = new LinkedHashMap<>();

        String input = scan.nextLine();

        while(input.equals("exam finished") == false){
            String[] inputData = input.split("-");
            String contestantName = inputData[0];
            String status = inputData[1];

            if(status.equals("banned") && pointsPerContestant.containsKey(contestantName)){
                pointsPerContestant.remove(contestantName);
            } else {
                int points = Integer.parseInt(inputData[2]);
                pointsPerContestant.putIfAbsent(contestantName, points);

                if(pointsPerContestant.get(contestantName) < points){
                    pointsPerContestant.put(contestantName,points);
                }


                submissionsPerLanguage.putIfAbsent(status, 0);
                submissionsPerLanguage.put(status, submissionsPerLanguage.get(status) +1);
            }

            input = scan.nextLine();
        }

        System.out.println("Results:");

        pointsPerContestant
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(contestant -> System.out.printf("%s | %d\n", contestant.getKey(), contestant.getValue()));

        System.out.println("Submissions:");

        submissionsPerLanguage
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(language -> System.out.printf("%s - %d\n", language.getKey(), language.getValue()));
    }
}
