package randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> random = new RandomArrayList<>();

        random.add(1);
        random.add(2);

        System.out.println(random.getRandomElement());
    }
}
