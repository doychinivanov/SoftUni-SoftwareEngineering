import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] usernames = scan.nextLine().split(", ");
        List<String> validUsernames = new ArrayList<>();

        for (String username: usernames) {
            if(validateUsername(username)){
                validUsernames.add(username);
            }
        }

        System.out.println(String.join("\n", validUsernames));
    }

    public static Boolean validateUsername(String username){
        if(username.length() < 3 || username.length() > 16){
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);
            if(!Character.isLetterOrDigit(currentChar) && currentChar != '_' && currentChar != '-'){
                return false;
            }
        }

        return true;
    }
}
