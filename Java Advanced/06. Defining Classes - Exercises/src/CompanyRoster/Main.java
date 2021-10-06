package CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] employeeData = scan.nextLine().split("\\s+");

            String employeeName = employeeData[0];
            double employeeSalary = Double.parseDouble(employeeData[1]);
            String employeePosition = employeeData[2];
            String employeeDepartment = employeeData[3];

            Employee currentEmployee = null;

            if(employeeData.length == 6){
                String employeeEmail = employeeData[4];
                int employeeAge = Integer.parseInt(employeeData[5]);

                currentEmployee = new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment, employeeEmail, employeeAge);
            } else if (employeeData.length == 5){
                String additionalParam = employeeData[4];

                if(additionalParam.contains("@")){
                    currentEmployee = new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment, additionalParam);
                } else {
                    currentEmployee = new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment, Integer.parseInt(additionalParam));
                }
            } else if(employeeData.length == 4){
                currentEmployee = new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment);
            }

            createDepartments(departments, employeeDepartment, currentEmployee);

        }

        Department bestDepartment = getDepartmentWithHighestAvgSalary(departments);

        System.out.println("Highest Average Salary: " + bestDepartment.getName());

        bestDepartment
                .getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

    }

    private static Department getDepartmentWithHighestAvgSalary(HashMap<String, Department> departments) {
        return departments
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().getAverageSalary()))
                .get().getValue();
    }

    private static void createDepartments(HashMap<String, Department> departments, String employeeDepartment, Employee currentEmployee) {
        departments.putIfAbsent(employeeDepartment, new Department(employeeDepartment));
        departments.get(employeeDepartment).getEmployees().add(currentEmployee);
    }
}
