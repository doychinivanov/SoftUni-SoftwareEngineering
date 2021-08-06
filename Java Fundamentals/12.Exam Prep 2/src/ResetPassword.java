import java.util.Scanner;

public class ResetPassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();
        String input = scan.nextLine();

        while(!input.equals("Done")){
            String[] inputData = input.split("\\s+");
            String command = inputData[0];

            if(command.equals("TakeOdd")){
                password = takeOnlyOdd(password);
            } else if(command.equals("Cut")){
                int startIndex = Integer.parseInt(inputData[1]);
                int substLength = Integer.parseInt(inputData[2]);

                password = cutString(password, startIndex, substLength);
            } else if(command.equals("Substitute")){
                String toBeReplaced = inputData[1];
                String toBeReplacedWith = inputData[2];

                password = replaceString(password, toBeReplaced, toBeReplacedWith);
            }

            input = scan.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }

    public static String takeOnlyOdd(String initialPass){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < initialPass.length(); i++) {
            if(i % 2 != 0){
                result.append(initialPass.charAt(i));
            }
        }

        System.out.println(result.toString());
        return result.toString();
    }

    public static String cutString(String password, int startIndex, int substLength){
        StringBuilder result = new StringBuilder();
        result.append(password, 0, startIndex);
        result.append(password.substring(startIndex+substLength));

        System.out.println(result);
        return  result.toString();
    }

    public static String replaceString(String password, String toBeReplaced, String toBeReplacedWith){
        if(password.contains(toBeReplaced)){
            password = password.replaceAll(toBeReplaced, toBeReplacedWith);
            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }

        return password;
    }
}
