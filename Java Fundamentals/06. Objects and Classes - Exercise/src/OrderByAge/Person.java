package OrderByAge;

public class Person {
    private String name;
    private int ID;
    private int age;

    public Person(String name, int ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    public int getAge() {
        return this.age;
    }
}
