package Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<Integer>();

        jar.add(5);
        jar.add(7);

        System.out.println(jar.remove());
    }
}
