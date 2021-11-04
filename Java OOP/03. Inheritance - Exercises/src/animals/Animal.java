package animals;

public class Animal {
    private String name;
    private String gender;
    private int age;

    public Animal (String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setAge(int age) {
        if(age < 0 ){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if(gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();

        result.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        result.append(String.format("%s %d %s", this.getName(), this.getAge(), this.getGender())).append(System.lineSeparator());
        result.append(this.produceSound());

        return result.toString();
    }
}
