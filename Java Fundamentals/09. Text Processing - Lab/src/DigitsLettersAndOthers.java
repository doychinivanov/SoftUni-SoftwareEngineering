import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        String str = scan.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                digits.append(str.charAt(i));
            } else if(Character.isLetter(str.charAt(i))){
                letters.append(str.charAt(i));
            } else {
                others.append(str.charAt(i));
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
