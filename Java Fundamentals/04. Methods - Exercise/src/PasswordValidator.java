import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        System.out.println(validate(password));
    }

    static String validate(String pass){
        String result = "";

        if(validateLength(pass) && countDigits(pass) && checkTypes(pass)){
            result = "Password is valid";
        }

        if(validateLength(pass) == false){
            result += "Password must be between 6 and 10 characters\n";
        }

        if (checkTypes(pass) == false){
            result += "Password must consist only of letters and digits\n";
        }

        if(countDigits(pass) == false){
            result += "Password must have at least 2 digits\n";
        }


        return  result;
    }

    static boolean validateLength(String pass){
        boolean isValid = false;

        if(pass.length() >=6 && pass.length() <= 10){
            isValid = true;
        }

        return isValid;
    }

    static boolean countDigits(String pass){
        boolean isValid = false;
        int digits = 0;

        for (int i = 0; i < pass.length() ; i++) {
            if(Character.isDigit(pass.charAt(i))){
                digits++;
            }

            if(digits >= 2){
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    static boolean checkTypes(String pass){
        boolean isValid = true;

        for (int i = 0; i < pass.length(); i++) {
            if(Character.isDigit(pass.charAt(i)) == false && Character.isLetter(pass.charAt(i)) == false){
                isValid = false;
            }
        }

        return isValid;
    }
}
