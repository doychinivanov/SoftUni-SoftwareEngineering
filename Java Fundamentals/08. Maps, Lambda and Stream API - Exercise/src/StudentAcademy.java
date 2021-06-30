import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentsData = new LinkedHashMap<>();
        Map<String, Double> graduatedStudents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scan.nextLine();
            double currentGrade = Double.parseDouble(scan.nextLine());

            studentsData.putIfAbsent(studentName, new ArrayList<>());
            studentsData.get(studentName).add(currentGrade);
        }

        studentsData
                .forEach((key, value) -> {
                    double currentAvg = value.stream().reduce(0.00, (acc, curr) -> acc + curr / value.size());

                    if(currentAvg >= 4.5){
                        graduatedStudents.putIfAbsent(key, currentAvg);
                    }
                });

        graduatedStudents
                .entrySet()
                .stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(student -> System.out.printf("%s -> %.2f\n", student.getKey(), student.getValue()));
    }
}