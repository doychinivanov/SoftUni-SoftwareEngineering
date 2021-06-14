package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<Student> studentsList = new ArrayList<>();

        while(input.equals("end") == false){
            String[] studentData = input.split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String city = studentData[3];

            if(isPresent(firstName, lastName, studentsList) == false){
                Student currentStudent = new Student(firstName, lastName, age, city);
                studentsList.add(currentStudent);
            } else {
                Student existingStudent = getStudent(firstName, lastName, studentsList);

                existingStudent.setFirstName(firstName);
                existingStudent.setLasName(lastName);
                existingStudent.setAge(age);
                existingStudent.setCity(city);
            }


            input = scan.nextLine();
        }

        String cityToFilterBy = scan.nextLine();

        List<Student> filteredList = studentsList.stream().filter(student -> student.getCity().equals(cityToFilterBy)).collect(Collectors.toList());

        for (Student student: filteredList) {
            System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLasName(), student.getAge());
        }
    }

    public static boolean isPresent(String firstName, String lastName, List<Student> studentsList){
        boolean alreadyExist = false;

        for (Student student: studentsList) {
            if(student.getFirstName().equals(firstName) && student.getLasName().equals(lastName)){
                alreadyExist = true;
                break;
            }
        }

        return alreadyExist;
    }

    private static Student getStudent(String firstName, String lastName, List<Student> studentsList){
        Student existingStudent = null;

        for (Student student: studentsList) {
            if(student.getFirstName().equals(firstName) && student.getLasName().equals(lastName)){
                existingStudent = student;
            }
        }

        return existingStudent;
    }
}