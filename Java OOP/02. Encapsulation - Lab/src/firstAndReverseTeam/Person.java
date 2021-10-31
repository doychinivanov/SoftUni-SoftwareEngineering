package firstAndReverseTeam;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.salary = salary;
    }

    public void setFirstName(String name){
        if(name.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }

        this.firstName = name;
    }

    public void setLastName(String name){
        if(name.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }

        this.lastName = name;
    }

    public void setAge(int age){
        if(age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void increaseSalary(double percentage) {
        if (this.getAge() < 30){
            this.setSalary(this.getSalary() + (this.getSalary() * percentage / 200));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * percentage / 100));
        }
    }

    @Override
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("####.0####");
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), formatter.format(this.getSalary()));
    }
}
