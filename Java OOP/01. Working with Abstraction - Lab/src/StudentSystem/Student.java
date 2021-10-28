package StudentSystem;

public class Student {
    private final String name;
    private final int age;
    private final double grade;
    private String comment;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.setComment();
    }

    private void setComment() {
        if(getGrade() >= 5.00){
            this.comment = "Excellent student.";
        } else if(getGrade() >= 3.50){
            this.comment = "Average student.";
        } else {
            this.comment = "Very nice person.";
        }
    }

    public String getName() {
        return this.name;
    }


    public double getGrade() {
        return this.grade;
    }

    public String getInfo(){
        return String.format("%s is %d years old. %s", this.name, this.age, this.comment);
    }
}
