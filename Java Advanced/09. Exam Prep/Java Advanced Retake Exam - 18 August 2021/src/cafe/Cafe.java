package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private final String name;
    private final int capacity;
    private final List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee newEmployee){
        if(capacity > employees.size()){
            this.employees.add(newEmployee);
        }
    }

    public boolean removeEmployee(String employeeName){
        Employee searchedEmployee = findEmployeeByName(employeeName);

        if(searchedEmployee != null){
            this.employees.remove(searchedEmployee);
            return true;
        }

        return false;
    }

    public Employee getEmployee(String employeeName){
        return findEmployeeByName(employeeName);
    }

    private Employee findEmployeeByName(String name){
        Employee found = null;

        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                found = employee;
                break;
            }
        }

        return found;
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).collect(Collectors.toList()).get(0);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder result = new StringBuilder();

        result.append(String.format("Employees working at Cafe %S:" + System.lineSeparator(), this.name));

        this.employees.forEach(employee -> result.append(employee.toString()).append(System.lineSeparator()));

        return result.toString();
    }
}
