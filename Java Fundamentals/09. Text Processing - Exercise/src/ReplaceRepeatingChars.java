import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String input = scan.nextLine();
        System.out.println(replaceChars(input));
    }

    public static String replaceChars(String text){
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length() -1; i++) {
            if(text.charAt(i) != text.charAt(i+1)){
                newText.append(text.charAt(i));
            }
        }

        newText.append(text.charAt(text.length() - 1));


        return  newText.toString();
    }
}
