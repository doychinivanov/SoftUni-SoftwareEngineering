import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String action = scan.nextLine();
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        findAction(action, a, b);
    }

    public static void findAction(String method, int a, int b){
        switch (method){
            case "add": add(a, b);
            break;
            case "multiply": multiply(a, b);
            break;
            case "subtract": subtract(a, b);
            break;
            case "divide": divide(a,b);
            break;
        }
    }

    public static void add(int x, int y){
        System.out.println(x + y);
    }

    public static void divide(int x, int y){
        System.out.println(x / y);
    }

    public static void multiply(int x, int y){
        System.out.println(x * y);
    }

    public static void subtract(int x, int y){
        System.out.println(x - y);
    }
}