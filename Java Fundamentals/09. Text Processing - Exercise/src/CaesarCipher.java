import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String planeText = scan.nextLine();

        System.out.println(encryptText(planeText));
    }

    public static String encryptText(String text){
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            encrypted.append((char)(text.charAt(i) + 3));
        }

        return encrypted.toString();
    }
}