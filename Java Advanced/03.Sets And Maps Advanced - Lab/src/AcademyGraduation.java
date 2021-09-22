import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, Double> graduationResults = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String studentName = scan.nextLine();
            List<Double> grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            double averageResult = grades.stream().reduce(0.0, Double::sum) / grades.size();

            graduationResults.putIfAbsent(studentName, averageResult);
        }

        graduationResults
                .forEach((studentName, score) -> {
                    System.out.print(studentName + " is graduated with ");
                    System.out.print(score);
                    System.out.println();
                });
    }

}
