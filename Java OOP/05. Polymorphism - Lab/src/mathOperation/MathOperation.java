package mathOperation;

public class MathOperation {

    public int add (int x, int y) {
        return x+ y;
    }

    public int add(int x, int y, int z) {
        return add(add(x, y), z);
    }

    public int add (int x, int y, int z, int e) {
        return add(add(x ,y, z), e);
    }
}
