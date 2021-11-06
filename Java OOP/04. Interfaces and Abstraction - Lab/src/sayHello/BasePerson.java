package sayHello;

public abstract class BasePerson implements Person{
    private final String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
