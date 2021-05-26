import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String input = scan.nextLine();

        System.out.println(countVowels(input));
    }

    public static int countVowels(String input){
        int vowels = 0;

        for (int i = 0; i < input.length(); i++) {
            if(Character.toLowerCase(input.charAt(i)) == 'a' ||
                    Character.toLowerCase(input.charAt(i)) == 'o' ||
                    Character.toLowerCase(input.charAt(i)) == 'e' ||
                    Character.toLowerCase(input.charAt(i)) == 'u' ||
                    Character.toLowerCase(input.charAt(i)) == 'i' ){
                vowels++;
            }
        }

        return vowels;
    }
}
