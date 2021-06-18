package Students;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Student> studentsData = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputData = scan.nextLine().split("\\s+");
            String firstName = inputData[0];
            String lastName = inputData[1];
            double grade = Double.parseDouble(inputData[2]);

            studentsData.add(new Student(firstName, lastName, grade));
        }

        studentsData.sort(Comparator.comparing(Student::getGrade).reversed());

        System.out.println(printElements(studentsData));
    }

    public static String printElements(List<Student> students){
        String result = "";

        for (Student student: students) {
            result += String.format("%s %s: %.2f\n", student.getFirstName(), student.getLastName(), student.getGrade());
        }

        return result;
    }
}
