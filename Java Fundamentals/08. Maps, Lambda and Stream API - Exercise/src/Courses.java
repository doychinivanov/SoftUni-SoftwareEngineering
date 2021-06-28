import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> coursesData = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (input.equals("end")==false){
            String[] currentCourseData = input.split(" : ");
            String courseName = currentCourseData[0];
            String studentName = currentCourseData[1];

            coursesData.putIfAbsent(courseName, new ArrayList<>());
            coursesData.get(courseName).add(studentName);

            input = scan.nextLine();
        }

        coursesData
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(course -> {
                    System.out.printf("%s: %d\n", course.getKey(), course.getValue().size());
                    course
                            .getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("-- %s\n", person));
                });
    }
}
