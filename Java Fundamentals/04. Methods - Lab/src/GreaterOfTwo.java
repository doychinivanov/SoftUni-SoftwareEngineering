import java.util.Scanner;

public class GreaterOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();

        if(type.equals("int")) {
            int a = Integer.parseInt(scan.nextLine());
            int b = Integer.parseInt(scan.nextLine());

            System.out.println(getMax(a, b));
        } else if (type.equals("string")){
            System.out.println(getMax(scan.nextLine(), scan.nextLine()));
        } else if (type.equals("char")){
            char a = scan.nextLine().charAt(0);
            char b = scan.nextLine().charAt(0);

            System.out.println(getMax(a, b));
        }

    }

    public static int getMax(int x, int y){
        return Math.max(x, y);
    }

    public static String getMax(String a, String b){
        if(a.compareTo(b) >= 0){
            return  a;
        }

        return b;
    }

    public static char getMax(char x, char y){
        if(x > y){
            return x;
        }

        return y;
    }
}
