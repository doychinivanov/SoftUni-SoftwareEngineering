import java.util.Scanner;

public class CharacterInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char firstSymbol = scan.nextLine().charAt(0);
        char secondSymbol = scan.nextLine().charAt(0);

        System.out.println(symbolsInRange(firstSymbol, secondSymbol));
    }

    public static String symbolsInRange(char x, char y){
        String result = "";

        if(x < y){
            for (int i = x + 1; i < y; i++) {
                result += (char)(i) + " ";
            }
        } else {
            for (int i = y + 1; i < x; i++) {
                result += (char)(i) + " ";
            }
        }

        return result;
    }
}
