import java.util.Scanner;

public class VowelSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int result = 0;

        for (int i = 0; i < input.length(); i++){
            char symbol = input.charAt(i);

            switch (symbol){
                case 'a':
                    result+= 1;
                    break;
                case 'e':
                    result+= 2;
                    break;
                case 'i':
                    result+= 3;
                    break;
                case 'o':
                    result+= 4;
                    break;
                case 'u':
                    result+= 5;
                    break;
            }
        }

        System.out.println(result);
    }
}

