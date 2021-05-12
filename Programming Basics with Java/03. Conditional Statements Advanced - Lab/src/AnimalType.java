import java.util.Scanner;

public class AnimalType {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animal = scan.nextLine();

        switch (animal){
            case "crocodile":
            case "tortoise":
            case "snake":
                System.out.println("reptile");
                break;
            case "dog":
                System.out.println("mammal");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}