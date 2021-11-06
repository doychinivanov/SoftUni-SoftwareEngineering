package borderControl;

public class Citizen implements Identifiable{
    private final String name;
    private final int age;
    private final String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
