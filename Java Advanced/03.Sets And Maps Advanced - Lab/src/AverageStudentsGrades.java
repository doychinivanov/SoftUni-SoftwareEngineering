import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, List<Double>> studentGrades = new TreeMap<>();

        int studentCount = Integer.parseInt(scan.nextLine());

        populateStudentGrades(scan, studentGrades, studentCount);


        studentGrades
                .forEach((name, grades) -> System.out.printf("%s -> %s(avg: %.2f)" + System.lineSeparator(),
                        name, getStringFromList(grades), getAverageGrade(grades)));
    }

    private static double getAverageGrade(List<Double> studentGrades) {
        return studentGrades.stream().reduce(0.0, Double::sum) / studentGrades.size();
    }

    public static String getStringFromList(List<Double> numbers){
        StringBuilder result = new StringBuilder();

        for (double number: numbers) {
            result.append(String.format("%.2f ", number));
        }

        return result.toString();
    }

    private static void populateStudentGrades(Scanner scan, TreeMap<String, List<Double>> studentGrades, int studentCount) {
        for (int i = 0; i < studentCount; i++) {
            String[] studentData = parseData(scan.nextLine(), "\\s+");

            String name = studentData[0];
            double currentGrade = Double.parseDouble(studentData[1]);

            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(currentGrade);
        }
    }

    public static String[] parseData(String input, String delimiter){
        return input.split(delimiter);
    }
}
