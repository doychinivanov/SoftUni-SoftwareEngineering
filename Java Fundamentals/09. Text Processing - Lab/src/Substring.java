import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String targetWord = scan.nextLine();
        String stringToModify = scan.nextLine();

        while (stringToModify.contains(targetWord)){
            stringToModify = stringToModify.replace(targetWord, "");
        }

        System.out.println(stringToModify);
    }
}
